package models.products

import models.dto.products.ProductDTO


case class Product(id: String, title: String, description: String)

object Product{
  implicit def convertProductDTO(productDTO: ProductDTO): Product = {
    Product(
      productDTO.id,
      productDTO.title,
      productDTO.description
    )
  }
}
