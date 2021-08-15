package com.kotlinsb.primespringbootkotlinms.controller

import com.kotlinsb.primespringbootkotlinms.entities.ProductInformation
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = ["/api/v1/products"])
class ProductController(val productService: ProductService) {

    @RequestMapping(value = ["/buy"],method = [RequestMethod.POST])
    fun buyProduct(@RequestBody product: ProductInformation): CommonResponse{
        return productService.buyProduct(product)
    }

    @RequestMapping(value = ["/sell"],method = [RequestMethod.POST])
    fun sellProduct(@RequestBody product: ProductInformation): CommonResponse{
        return productService.sellProduct(product)
    }

    @RequestMapping(value = ["/{userName}"],method = [RequestMethod.GET])
    fun productOwnedByUser(@PathVariable userName: String): List<ProductInformation?>?{
        return productService.fetchProductOwnedByUser(userName)
    }
}