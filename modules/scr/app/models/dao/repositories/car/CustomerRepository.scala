package models.dao.repositories.car

import models.dao.entities.car._
import models.dao.repositories.CrudRepository
import models.dao.schema.CarSharingSchema
import org.squeryl.Table

trait CustomerRepository extends CrudRepository[String,Customer]{

    def findByEmailAndPassword(email: String,password: String): Boolean
}


class CustomerRepositoryCRUDImpl extends CustomerRepository {


    override def defaultTable: Table[Customer] = CarSharingSchema.customer

    override def findByEmailAndPassword(email: String, password: String): Boolean =
        transaction(
            from(CarSharingSchema.customer)(c =>
                where(c.email === email and password === c.password)
                    select c).headOption match {
                case Some(x) => true
                case None => false
            }
        )
}
