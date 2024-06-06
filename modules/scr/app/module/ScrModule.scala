package module

import di.AppModule
import models.dao.repositories.car.{CarRepositoryCRUD, CarRepositoryCRUDImpl, CustomerRepository, CustomerRepositoryCRUDImpl, ModelRepositoryCRUD, ModelRepositoryCRUDImpl, ReservationRepository, ReservationRepositoryCRUDImpl}
import models.services.car.{CarService, CarServiceImpl, CustomerService, CustomerServiceImpl, ModelService, ModelServiceImpl, ReservationService, ReservationServiceImpl}

class ScrModule extends AppModule {
    override def configure(): Unit = {
        bindSingleton[CustomerRepository, CustomerRepositoryCRUDImpl]
        bindSingleton[CustomerService, CustomerServiceImpl]
        bindSingleton[CarRepositoryCRUD, CarRepositoryCRUDImpl]
        bindSingleton[CarService, CarServiceImpl]
        bindSingleton[ModelRepositoryCRUD, ModelRepositoryCRUDImpl]
        bindSingleton[ModelService, ModelServiceImpl]
        bindSingleton[ReservationRepository, ReservationRepositoryCRUDImpl]
        bindSingleton[ReservationService, ReservationServiceImpl]
    }
}