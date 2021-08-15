package com.kotlinsb.primespringbootkotlinms.repository

import com.kotlinsb.primespringbootkotlinms.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>{
    fun findCustomerByUserNameOrEmail(userName: String?, email: String?): Customer?
    fun findCustomerByUserNameAndPassword(userName: String?, password: String?): Customer?
}