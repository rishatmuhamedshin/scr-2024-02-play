package models.dao.repositories.car

import models.dao.entities.car._
import models.dao.repositories.CrudRepository
import models.dao.schema.CarSharingSchema
import org.squeryl.Table

trait CarRepositoryCRUD extends CrudRepository[String,Car]{}


class CarRepositoryCRUDImpl extends CarRepositoryCRUD {

    override def defaultTable: Table[Car] = CarSharingSchema.car
}
