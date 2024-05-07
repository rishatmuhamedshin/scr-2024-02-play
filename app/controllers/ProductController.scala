package controllers

import models.dto.products.ProductDTO
import models.service.ProductService
import play.api.mvc.{Action, Controller}

object ProductController extends Controller {


  def addProduct = Action(parse.json[ProductDTO]) { rc =>
    val body: ProductDTO = rc.body
    ProductService.productAddOrUpdate(body)
    Ok(body.toString)
  }

  def deleteProduct(id: String) = Action {
    if (ProductService.productDelete(id)) {
      Ok("Product Delete")
    } else {
      NotFound
    }
  }

  def listProducts(title: Option[String]) = Action {
    Ok(views.html.products.list(
      ProductService.showProducts(title)
    ))
  }


}
