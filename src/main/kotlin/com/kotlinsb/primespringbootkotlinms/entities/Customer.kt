package com.kotlinsb.primespringbootkotlinms.entities

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "Customer")
data class Customer(@Id
                    @Column(name = "Id")
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    val id: Long,
                    @Column(name = "User_Name")
                    val userName: String?,
                    @Column(name = "First_Name")
                    val firstName: String?,
                    @Column(name = "Last_Name")
                    val lastName: String?,
                    @Column(name = "Email")
                    val email: String?,
                    @Column(name = "Organization_Name")
                    val organizationName: String?,
                    @Column(name = "Registered_Date")
                    var registeredDate: LocalDate?,
                    @Column(name = "Pan_Number")
                    val panNumber: String?,
                    @Column(name = "Password")
                    val password: String?,
                    @Column(name = "Address01")
                    val addressLine01: String?,
                    @Column(name = "Address02")
                    val addressLine02: String?,
                    @Column(name = "State")
                    val state: String?,
                    @Column(name = "Country")
                    val country: String?,
                    @Column(name = "Pincode")
                    val pincode: String?,
                    @Column(name = "UserType")
                    val userType: String?,
                    @Column(name = "LastLogInDate")
                    var lastLogInDate: LocalDate?)
