package models.services.car

import com.google.inject.Inject
import models.dao.entities.car.{Car, Customer}
import models.dao.repositories.car.CarRepositoryCRUDImpl
import models.dto.{CarDTO, CustomerDTO}

trait CarService {
    def find(id: String): Option[Car]

    def list(): List[Car]

    def update(car: Car)

    def delete(car: Car)

    def insert(car: Car)

    def insert(carDto: CarDTO)
}

class CarServiceImpl @Inject()(val carRepository: CarRepositoryCRUDImpl) extends CarService {

    override def find(id: String): Option[Car] = carRepository.find(id)

    override def list(): List[Car] = carRepository.list()

    override def update(car: Car): Unit = carRepository.update(car)

    override def delete(car: Car): Unit = carRepository.delete(car)

    override def insert(car: Car): Unit = carRepository.insert(car)

    override def insert(carDto: CarDTO): Unit = carRepository.insert(carDto)

    implicit def customerDTOtoCustomer(c: CarDTO): Car =
        Car(
            id = (c.mileage + c.releaseDate + c.priceHour).hashCode.toString,
            mileage = c.mileage,
            regNumber = c.regNumber,
            description = c.description,
            modelId = c.modelId,
            priceHour = c.priceHour,
            address = c.address,
            releaseDate = c.releaseDate
        )

}
