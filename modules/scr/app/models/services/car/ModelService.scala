package models.services.car

import com.google.inject.Inject
import models.dao.entities.car.{Customer, Model}
import models.dao.repositories.car.ModelRepositoryCRUD

trait ModelService {

    def find(id: String): Option[Model]
    def list(): List[Model]
    def update(model: Model)
    def delete(model: Model)
    def insert(model:  Model)
}
class ModelServiceImpl @Inject()(val modelRepositoryCRUD: ModelRepositoryCRUD) extends ModelService {

    override def find(id: String): Option[Model] = modelRepositoryCRUD.find(id)

    override def list(): List[Model] = modelRepositoryCRUD.list()

    override def update(model: Model): Unit = modelRepositoryCRUD.update(model)

    override def delete(model: Model): Unit = modelRepositoryCRUD.delete(model)

    override def insert(model: Model): Unit = modelRepositoryCRUD.insert(model)
}

