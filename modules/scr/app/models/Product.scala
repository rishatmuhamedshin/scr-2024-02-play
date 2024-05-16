package models

import models.dto.products.ProductDTO
import org.squeryl.KeyedEntity


case class Product(id: String, title: String, description: String) extends KeyedEntity[String]

object Product{
  implicit def convertProductDTO(productDTO: ProductDTO): Product = {
    Product(
      productDTO.id,
      productDTO.title,
      productDTO.description
    )
  }
}