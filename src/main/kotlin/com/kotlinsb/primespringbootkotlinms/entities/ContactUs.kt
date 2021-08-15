package com.kotlinsb.primespringbootkotlinms.entities

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Contact_Us")
data class ContactUs(
        @Id
        @Column(name = "Id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private var id: Long?,
        @Column(name = "User_Name")
        val userName: String?,

        @Column(name = "Email")
        val email: String?,

        @Column(name = "Phone_Number")
        val phoneNumber: String?,

        @Column(name = "Message")
        val message: String?,

        @Column(name = "Message_Added_On")
        var messageDate: LocalDate? = null
)
