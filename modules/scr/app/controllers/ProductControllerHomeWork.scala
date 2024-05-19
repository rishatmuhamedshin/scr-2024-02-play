package controllers

import com.google.inject.Inject
import models.dto.products.ProductDTO
import models.services.ProductService
import play.api.mvc.{Action, Controller}

class ProductControllerHomeWork @Inject()(val productService: ProductService) extends Controller{

    def addProduct() = Action(parse.json[ProductDTO]){ rq =>
        productService.addProduct(rq.body)
        Ok("")
    }

    def updateProduct() = Action(parse.json[ProductDTO]){ rq =>
        productService.updateProduct(rq.body)
        Ok("")
    }

    def deleteProduct(id: String) = Action{
        productService.delete(id)
        Ok("")
    }

    def listProducts(title: Option[String]) = Action {
        title match {
            case Some(x) => Ok(views.html.products.list(
                List(productService.findByTitle(x))
            ))
            case None =>  Ok(views.html.products.list(
                productService.listProducts()
            ))
        }
    }


}
