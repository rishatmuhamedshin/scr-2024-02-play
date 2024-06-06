package models.dao.entities.car

import models.dao.schema.CarSharingSchema
import org.squeryl.KeyedEntity

case class Car(
                  id: String,
                  mileage: String,
                  regNumber: String,
                  description: String,
                  modelId: String,
                  priceHour: String,
                  address: String,
                  releaseDate: String
              ) extends KeyedEntity[String] {
    lazy val reservations = CarSharingSchema.reservationCar.left(this)

}
