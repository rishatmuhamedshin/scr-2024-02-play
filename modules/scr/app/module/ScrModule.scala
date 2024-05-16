package module

import controllers.ProductController
import di.AppModule
import models.dao.repositories.{PhoneRecordRepository, PhoneRecordRepositoryImpl, ProductItemRepository, ProductItemRepositoryImpl, ProductRepository, ProductRepositoryImpl}
import models.services.{LogService, LogServiceImpl, ProductService}

class ScrModule extends AppModule{
  override def configure(): Unit = {
    bindSingleton[LogService, LogServiceImpl]
    bindSingleton[PhoneRecordRepository, PhoneRecordRepositoryImpl]
    bindSingleton[ProductRepository,ProductRepositoryImpl]
    bindSingleton[ProductItemRepository, ProductItemRepositoryImpl]
  }
}
