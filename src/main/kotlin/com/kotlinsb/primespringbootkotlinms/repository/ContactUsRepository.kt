package com.kotlinsb.primespringbootkotlinms.repository

import com.kotlinsb.primespringbootkotlinms.entities.ContactUs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactUsRepository: JpaRepository<ContactUs, Long> {

}