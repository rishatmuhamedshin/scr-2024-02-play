package controllers.car

import com.google.inject.Inject
import conttrollers.Authorization
import models.dto.CustomerDTO
import models.services.car.{CarService, CustomerService, ModelService}
import play.api.data.Forms.{email, nonEmptyText, text}
import play.api.data.{Form, Forms, Mapping}
import play.api.mvc.Action

class RegistrationController @Inject()(val customerService: CustomerService,
                                       val modelService: ModelService) extends Authorization{

    val mapping: Mapping[CustomerDTO] = Forms.mapping(
        "firstName" -> nonEmptyText(minLength = 3),
        "lastName" -> nonEmptyText(minLength = 3),
        "licenseNumber" -> text,
        "city" -> nonEmptyText(minLength = 3),
        "street" -> nonEmptyText(minLength = 3),
        "email" -> email,
        "password" -> nonEmptyText(minLength = 6)
    )(CustomerDTO.apply)(CustomerDTO.unapply)



    val registrationForm: Form[CustomerDTO] = Form(mapping)

    def registration =  Action {
        Ok(views.html.registration(registrationForm))
    }

    def registrationCustomer = Action{ implicit req =>
        registrationForm.bindFromRequest.fold(
            formWithErrors => BadRequest(views.html.registration(formWithErrors)),
            dto => {
                customerService.insert(dto)
                Redirect(routes.MainController.showClients()).withSession("email" -> dto.email)
            }
        )
    }
}
