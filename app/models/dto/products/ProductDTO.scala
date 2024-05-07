package models.dto.products

import play.api.libs.json.{Json, Reads, Writes}

case class ProductDTO(id: String, title: String, description: String, list: List[ProductItemDTO])

object ProductDTO{
  implicit val reads: Reads[ProductDTO] = Json.reads[ProductDTO]
  implicit val write: Writes[ProductDTO] = Json.writes[ProductDTO]
}
