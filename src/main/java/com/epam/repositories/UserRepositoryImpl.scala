package com.epam.repositories

import com.epam.models.enums.Gender.StringExt_Gender
import com.epam.models.enums.Gender
import com.epam.models.enums.MaritalStatus.StringExt_MaritalStatus
import com.epam.context.AppDataContext
import com.epam.models.enums.{Gender, MaritalStatus}
import com.epam.models.user.{FilterUserRequest, User}
import org.springframework.stereotype.Component

@Component
case class UserRepositoryImpl(private val context: AppDataContext) extends UserRepository {

  override def filter(request: FilterUserRequest): List[User] = {
    val result = context.cachedUsers.filter(user => filterUser(user, request));
    return result
  }

  private def filterUser(user: User, request: FilterUserRequest): Boolean = {
    val answer = request match {
      case FilterUserRequest(prefix_name, _, _, _, _, _) if (prefix_name != null && !user.name.startsWith(prefix_name)) => false
      case FilterUserRequest(_, min_age, _, _, _, _) if (min_age != null && user.age < min_age.toIntOption.getOrElse(-1)) => false
      case FilterUserRequest(_, _, max_age, _, _, _) if (max_age != null && user.age > max_age.toIntOption.getOrElse(Int.MaxValue)) => false
      case FilterUserRequest(_, _, _, gender, _, _) if (gender != null && !gender.trim.isEmpty && (!gender.isValidGener || user.gender != Gender.parse(gender))) => false
      case FilterUserRequest(_,_,_,_,merital_status,_) if ( merital_status!=null && !merital_status.trim.isEmpty && (   !merital_status.isValidMaritalStatus    || user.maritalStatus != MaritalStatus.parseToOption(merital_status) )) => false
      case FilterUserRequest(_, _, _, _, _, number_of_children) if (number_of_children != null && !number_of_children.isEmpty && (number_of_children.toIntOption == None || user.number_of_children != number_of_children.toIntOption)) => false
      case _ => true
    }
    return answer;

  }
}
