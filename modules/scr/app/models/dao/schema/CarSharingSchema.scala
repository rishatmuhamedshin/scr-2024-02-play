package models.dao.schema

import models.dao.entities.car._
import org.squeryl.Schema

object CarSharingSchema extends Schema {

    import org.squeryl.PrimitiveTypeMode._

    val car = table[Car]
    val customer = table[Customer]
    val model = table[Model]
    val reservation = table[Reservation]


    val modelCar = oneToManyRelation(model, car).via(_.id === _.modelId)
    val reservationCustomer = oneToManyRelation(customer, reservation).via(_.id === _.customerId)
    val reservationCar = oneToManyRelation(car, reservation).via(_.id === _.carId)


}
