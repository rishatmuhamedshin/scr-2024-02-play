package models.dto

case class ReservationDTO( pickUpDate: String,
                           amount: String,
                           returnDate: String,
                           pickUpLocation: String,
                           carId: String,
                           customerId: String)
