package models.repository

import models.products.{Product, ProductItem}

import scala.collection.mutable

object ProductRepository {
  val repository: mutable.Map[Product, List[ProductItem]] = mutable.Map[Product, List[ProductItem]]()


  //  val p: Product = Product("1","123","1234")
  //  val l: List[ProductItem] = List[ProductItem](
  //    ProductItem("4",123,45,true),
  //    ProductItem("432",222.3,1,false)
  //  )

}
