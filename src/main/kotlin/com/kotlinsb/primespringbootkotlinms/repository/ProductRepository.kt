package com.kotlinsb.primespringbootkotlinms.repository

import com.kotlinsb.primespringbootkotlinms.entities.ProductInformation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<ProductInformation, Long> {
    fun findProductInformationByUserName(userName: String?): List<ProductInformation?>?
    fun findProductInformationByUserNameAndProductID(userName: String?, productId: String?): ProductInformation?
}