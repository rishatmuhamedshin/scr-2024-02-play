package models.dao.entities.car

import models.dao.schema.CarSharingSchema
import org.squeryl.KeyedEntity

case class Customer(
                       id: String,
                       firstName: String,
                       licenseNumber: String,
                       lastName: String,
                       city: String,
                       street: String,
                       email: String,
                       password: String,
                       role: String
                   ) extends KeyedEntity[String] {
    lazy val reservations = CarSharingSchema.reservationCustomer.left(this)
}

