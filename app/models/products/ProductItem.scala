package models.products

import models.dto.products.ProductItemDTO

case class ProductItem(id: String, price: Double, count: Int, inStock: Boolean)

object ProductItem{
  implicit def convertProductItemDTO(productItemDTO: ProductItemDTO): ProductItem = {
    ProductItem(
      productItemDTO.id,
      productItemDTO.price,
      productItemDTO.count,
      productItemDTO.inStock
    )
  }
}
