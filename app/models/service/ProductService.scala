package models.service

import models.dto.products.ProductDTO
import models.products.{Product, ProductItem}
import models.repository.ProductRepository

import scala.collection.mutable

object ProductService {


  val repository: mutable.Map[Product, List[ProductItem]] = ProductRepository.repository

  def productAddOrUpdate(productDTO: ProductDTO): Unit = {

    val list: List[ProductItem] = productDTO.list.map(ProductItem.convertProductItemDTO)
    val product: Product = productDTO
    repository.update(product,list)

  }

  def productDelete(id: String): Boolean = {
    repository.keySet.find(_.id == id) match {
      case Some(x) => repository.remove(x) match {
        case Some(_) => true
        case None => false
      }
      case None => false
    }
  }


  def showProducts(title: Option[String]):mutable.Map[Product, List[ProductItem]] = {
    title match {
      case Some(x) => findByTitle(x)
      case None => repository
    }
  }

  private def findByTitle(titleProduct: String): mutable.Map[Product, List[ProductItem]] = {
    repository.collect{
      case (product, items) if(product.title == titleProduct) => (product,items)
    }
  }



}
