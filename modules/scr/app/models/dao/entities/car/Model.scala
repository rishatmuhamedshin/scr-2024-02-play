package models.dao.entities.car

import models.dao.schema.CarSharingSchema
import org.squeryl.KeyedEntity

case class Model (
                     id: String,
                     classes: String,
                     typeBody: String,
                     brand: String
                 ) extends KeyedEntity[String]{
    lazy val cars = CarSharingSchema.modelCar.left(this)
}
