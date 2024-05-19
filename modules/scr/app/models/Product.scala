package models

import models.dao.schema.ProductSchema
import models.dto.products.ProductDTO
import org.squeryl.KeyedEntity


case class Product(id: String, title: String, description: String) extends KeyedEntity[String]{
    lazy val productItems = ProductSchema.productInProductsItems.left(this)
}

object Product{
    implicit def convertProductDTO(productDto: ProductDTO):Product  = {
        Product(productDto.title,productDto.title,productDto.description)
    }
    implicit def convertProduct(product: Product):ProductDTO  = {
        val list = product.productItems.toList.map(ProductItem.convertDTOToProductItem)
        ProductDTO(product.title,product.title,product.description,list)
    }
}
