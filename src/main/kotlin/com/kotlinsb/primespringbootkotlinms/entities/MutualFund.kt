package com.kotlinsb.primespringbootkotlinms.entities

import com.kotlinsb.primespringbootkotlinms.enum.FundType
import com.kotlinsb.primespringbootkotlinms.enum.MutualFundPaymentMode
import com.kotlinsb.primespringbootkotlinms.enum.MutualFundRiskLevel
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "Mutual_Fund")
data class MutualFund(
        @Id
        @Column(name = "Id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "User_Name")
        val userName: String?,

        @Column(name = "Fund_Type")
        val fundType: FundType?,

        @Column(name = "Risk_Level")
        val riskLevel: MutualFundRiskLevel?,

        @Column(name = "Tenure")
        val tenure: Int = 0,

        @Column(name = "Investment_Amount")
        val investmentAmount: Double = 0.0,

        @Column(name = "Payment_Mode")
        val paymentMode: MutualFundPaymentMode?,

        @Column(name = "Maturity_Amount")
        val maturityAmount: Double = 0.0,

        @Column(name = "Registration_Date")
        var registrationDate: LocalDate?,
)
