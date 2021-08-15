package com.kotlinsb.primespringbootkotlinms.entities

import com.kotlinsb.primespringbootkotlinms.enum.ProductSubCategory
import com.kotlinsb.primespringbootkotlinms.enum.ProductType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="ProductInformation")
data class ProductInformation(
        @Id @Column(name = "Id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @javax.persistence.Column(name = "User_Name")
        val userName: String?,

        @Column(name = "Product_Name")
        val productName: String?,

        @Column(name = "Product_Id")
        val productID: String?,

        @Column(name = "Product_Type")
        val productType: ProductType?,

        @Column(name = "Sub_Category")
        val subcategory: ProductSubCategory?,

        @Column(name = "Buy_Price")
        val buyPrice: Double?,

        @Column(name = "Market_Price")
        val marketPrice: Double,

        @Column(name = "Quantity")
        var quantity: Int = 0
)
