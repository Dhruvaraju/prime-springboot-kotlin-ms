package com.kotlinsb.primespringbootkotlinms.service

import com.kotlinsb.primespringbootkotlinms.entities.ProductInformation
import com.kotlinsb.primespringbootkotlinms.enum.ProductType
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepo: ProductRepository) {

    fun buyProduct(product : ProductInformation): CommonResponse{
        val productFromStore = productRepo.findProductInformationByUserNameAndProductID(product.userName, product.productID)
        return if (null == productFromStore) {
            productRepo.save(product)
            CommonResponse("ADDED", "Product added to your portfolio")
        } else if (productFromStore.productType === ProductType.FP) {
            CommonResponse("EXISTS", "Product available in your portfolio")
        } else {
            product.quantity = product.quantity?.let { productFromStore.quantity?.plus(it) }
            productRepo.save(product)
            CommonResponse("ADDED", "Product added to your portfolio")
        }
    }

    fun sellProduct(product: ProductInformation): CommonResponse {
        val productFromStore = productRepo.findProductInformationByUserNameAndProductID(product.userName, product.productID)
        return if (null == productFromStore || product.quantity > productFromStore.quantity) {
            CommonResponse("INVALID", "Product not in Portfolio or insufficient quantity")
        } else if (productFromStore.quantity === product.quantity) {
            productRepo.delete(productFromStore)
            CommonResponse("UPDATED", "Product sale initiation successful.")
        } else {
            productFromStore.quantity = (productFromStore.quantity - product.quantity)
            productRepo.save(productFromStore)
            CommonResponse("UPDATED", "Product sale initiation successful.")
        }
    }

    fun fetchProductOwnedByUser(userName: String?): List<ProductInformation?>? {
        return productRepo.findProductInformationByUserName(userName)
    }

}