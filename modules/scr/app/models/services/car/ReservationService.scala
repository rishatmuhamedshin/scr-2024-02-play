package models.services.car

import com.google.inject.Inject
import models.dao.entities.car.{Car, Reservation}
import models.dao.repositories.car.ReservationRepository
import models.dto.{CarDTO, ReservationDTO}

trait ReservationService {
    def find(id: String): Option[Reservation]

    def list(): List[Reservation]

    def update(reservation: Reservation)

    def delete(reservation: Reservation)

    def insert(reservation: Reservation)

    def insert(reservationDTO: ReservationDTO)
}

class ReservationServiceImpl @Inject()(val reservationRepository: ReservationRepository) extends ReservationService {


    override def find(id: String): Option[Reservation] = reservationRepository.find(id)

    override def list(): List[Reservation] = reservationRepository.list()

    override def update(reservation: Reservation): Unit = reservationRepository.update(reservation)

    override def delete(reservation: Reservation): Unit = reservationRepository.delete(reservation)

    override def insert(reservation: Reservation): Unit = reservationRepository.insert(reservation)

    override def insert(reservationDTO: ReservationDTO): Unit = reservationRepository.insert(reservationDTO)

    implicit def customerDTOtoCustomer(r: ReservationDTO): Reservation =
        Reservation(
            id = (r.customerId + r.carId).hashCode.toString,
            pickUpDate = r.pickUpDate,
            amount = r.amount,
            returnDate = r.returnDate,
            pickUpLocation = r.pickUpLocation,
            carId = r.carId,
            customerId = r.customerId
        )


}