package models.dao.repositories.car

import models.dao.entities.car._
import models.dao.repositories.CrudRepository
import models.dao.schema.CarSharingSchema
import org.squeryl.Table

trait ModelRepositoryCRUD extends CrudRepository[String,Model]{}


class ModelRepositoryCRUDImpl extends ModelRepositoryCRUD {

    override def defaultTable: Table[Model] = CarSharingSchema.model
}