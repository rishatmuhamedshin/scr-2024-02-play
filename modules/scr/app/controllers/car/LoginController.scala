package controllers.car


import com.google.inject.Inject
import conttrollers.Authorization
import models.dto.LoginDTO
import models.services.car.{CarService, CustomerService, ModelService}
import play.api.data.Forms.{email, nonEmptyText}
import play.api.data.{Form, Forms, Mapping}
import play.api.mvc.Action

class LoginController @Inject()(val customerService: CustomerService,
                                val modelService: ModelService,
                                val carService: CarService
                               ) extends Authorization {

    val mapping: Mapping[LoginDTO] = Forms.mapping(
        "email" -> email,
        "password" -> nonEmptyText(minLength = 6)
    )(LoginDTO.apply)(LoginDTO.unapply)


    val loginForm: Form[LoginDTO] = Form(mapping)

    def loginPage = Action {
        Ok(views.html.login(loginForm))
    }

    def loginFormSubmit = Action { implicit req =>
        loginForm.bindFromRequest.fold(
            formWithErrors => BadRequest(views.html.login(formWithErrors)),
            dto => customerService.check(dto.email, dto.password) match {
                case true => Redirect(routes.LoginController.index()).withSession("email" -> dto.email)
                case false => Redirect(routes.RegistrationController.registration())
            }
        )
    }

    def logOut() = Action { implicit rc =>
        Ok("Bye bye").withSession(rc.session - "email")
    }


    def index() = authorize {
        Ok(views.html.index(modelService.list(), carService.list()))
    }


}
