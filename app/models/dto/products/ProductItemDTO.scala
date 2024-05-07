package models.dto.products

import play.api.libs.json.{Json, Reads, Writes}

case class ProductItemDTO(id: String, price: Double, count: Int, inStock: Boolean)

object ProductItemDTO{
  implicit val reads: Reads[ProductItemDTO] = Json.reads[ProductItemDTO]
  implicit val writes: Writes[ProductItemDTO] = Json.writes[ProductItemDTO]
}
