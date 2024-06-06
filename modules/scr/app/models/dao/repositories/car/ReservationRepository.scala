package models.dao.repositories.car

import models.dao.entities.car._
import models.dao.repositories.CrudRepository
import models.dao.schema.CarSharingSchema
import org.squeryl.Table

trait ReservationRepository extends CrudRepository[String,Reservation]{}


class ReservationRepositoryCRUDImpl extends ReservationRepository {

    override def defaultTable: Table[Reservation] = CarSharingSchema.reservation
}