package controllers

import com.google.inject.Inject
import models.dto.products.ProductDTO
import models.services.ProductService
import play.api.mvc.{Action, Controller}


class ProductController @Inject()(val productService: ProductService) extends Controller {


  def addProduct = Action(parse.json[ProductDTO]) { rc =>
    val body: ProductDTO = rc.body
    productService.productAddOrUpdate(body)
    Ok(body.toString)
  }

  def deleteProduct(id: String) = Action {
    if (productService.productDelete(id)) {
      Ok("Product Delete")
    } else {
      NotFound
    }
  }

  def listProducts(title: Option[String]) = Action {
    Ok(views.html.products.list(
      productService.showProducts(title)
    ))
  }


}
