package com.kotlinsb.primespringbootkotlinms.controller

import com.kotlinsb.primespringbootkotlinms.entities.Customer
import com.kotlinsb.primespringbootkotlinms.model.AuthenticatedUser
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.service.CustomerService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = ["/api/v1"])
class CustomerController(val customerService: CustomerService) {

    @RequestMapping(value = ["/register"])
    fun registerCustomer(@RequestBody customer: Customer): CommonResponse{
        return customerService.addCustomer(customer)
    }

    @RequestMapping(value = ["/authenticate"])
    fun authenticateUser(@RequestBody customer: Customer): AuthenticatedUser {
        return  customerService.authenticateCustomer(customer)
    }
}