package controllers.car

import com.google.inject.Inject
import conttrollers.Authorization
import models.dao.entities.car.Car
import models.dto.{CarDTO, CustomerDTO, ReservationDTO}
import models.services.car.{CarService, CustomerService, ModelService, ReservationService}
import play.api.data.Forms.nonEmptyText
import play.api.data.{Form, Forms, Mapping}
import play.api.mvc.Action

class MainController  @Inject()(val customerService: CustomerService,
                                val modelService: ModelService,
                                val carService: CarService ,
                                val reservationService: ReservationService) extends Authorization {


    def showClients = authorize{
        Ok(views.html.customer(customerService.list()))
    }
    def showCarForm = authorize{
        Ok(views.html.createCar(carForm))
    }

    val mapping: Mapping[CarDTO] = Forms.mapping(
        "mileage" -> nonEmptyText(minLength = 6),
        "regNumber" -> nonEmptyText(minLength = 6),
        "description" -> nonEmptyText(minLength = 10),
        "modelId" -> nonEmptyText(),
        "hour" -> nonEmptyText(),
        "address" -> nonEmptyText(),
        "releaseDate" -> nonEmptyText
    )(CarDTO.apply)(CarDTO.unapply)

    val carForm: Form[CarDTO] = Form(mapping)

    def carCreate = Action{ implicit req =>
        carForm.bindFromRequest.fold(
            formWithErrors => BadRequest(views.html.createCar(formWithErrors)),
            dto => {
                carService.insert(dto)
                Redirect(routes.MainController.showClients())
            }
        )
    }


//    val reservationForm: Form[ReservationDTO] = Form(mapping2)
//
//    val mapping2: Mapping[ReservationDTO] = Forms.mapping(
//        "pickUpDate" -> nonEmptyText(minLength = 6),
//        "amount" -> nonEmptyText(minLength = 6),
//        "returnDate" -> nonEmptyText(minLength = 10),
//        "pickUpLocation" -> nonEmptyText(),
//        "carId" -> nonEmptyText(),
//        "customerId" -> nonEmptyText
//    )(ReservationDTO.apply)(ReservationDTO.unapply)
//
//
//    def showReservation = Action{
//        Ok(views.html.reservations(reservationService.list()))
//    }
//    def reservationCreate = Action{ implicit req =>
//        reservationForm.bindFromRequest.fold(
//            formWithErrors => BadRequest(views.html.createReservation(formWithErrors)),
//            dto => {
//                reservationService.insert(dto)
//                Redirect(routes.MainController.showClients())
//            }
//        )
//    }





}

