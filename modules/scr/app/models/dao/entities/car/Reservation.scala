package models.dao.entities.car

import models.dao.schema.CarSharingSchema
import org.squeryl.KeyedEntity

case class Reservation (
                       id: String,
                       pickUpDate: String,
                       amount: String,
                       returnDate: String,
                       pickUpLocation: String,
                       carId: String,
                       customerId: String
                       ) extends KeyedEntity[String]
{

}
