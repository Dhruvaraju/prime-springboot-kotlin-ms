package com.kotlinsb.primespringbootkotlinms.entities

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Ipo_Information")
data class IpoInformation(
        @Id
        @Column(name = "Id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "Username")
        val userName: String?,

        @Column(name = "Company_Name")
        val companyName: String?,

        @Column(name = "Market_Cap")
        val marketCap: Double = 0.0,

        @Column(name = "Sale_Percent")
        val salePercentage: Double = 0.0,

        @Column(name = "Description")
        var description: String?,

        @Column(name = "Issue_Date")
        var issueDate: LocalDate?,

        @Column(name = "Issue_Size")
        var issueSize: Long = 0,

        @Column(name = "Issue_Price")
        var issuePrice: Double = 0.0,

        @Column(name = "Lot_Size")
        var lotSize: Long = 0,

        @Column(name = "Closing_Date")
        var closingDate: LocalDate?,
)
