package module

import di.AppModule
import models.dao.repositories.{PhoneRecordRepository, PhoneRecordRepositoryCRUD, PhoneRecordRepositoryCRUDImpl, PhoneRecordRepositoryImpl, ProductItemRepository, ProductItemRepositoryImpl, ProductRepository, ProductRepositoryImpl, SongRepository, SongRepositoryImpl}
import models.services.{LogService, LogServiceImpl}

class ScrModule extends AppModule{
  override def configure(): Unit = {
    bindSingleton[LogService, LogServiceImpl]
    bindSingleton[PhoneRecordRepository, PhoneRecordRepositoryImpl]
    bindSingleton[SongRepository, SongRepositoryImpl]
    bindSingleton[PhoneRecordRepositoryCRUD, PhoneRecordRepositoryCRUDImpl]
    bindSingleton[ProductItemRepository,ProductItemRepositoryImpl]
    bindSingleton[ProductRepository,ProductRepositoryImpl]
  }
}
