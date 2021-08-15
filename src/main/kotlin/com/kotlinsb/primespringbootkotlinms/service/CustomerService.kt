package com.kotlinsb.primespringbootkotlinms.service

import com.kotlinsb.primespringbootkotlinms.entities.Customer
import com.kotlinsb.primespringbootkotlinms.model.AuthenticatedUser
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CustomerService(val customerRepository: CustomerRepository) {
    fun addCustomer(customer: Customer): CommonResponse {
        var availableCustomer: Customer? = customerRepository.findCustomerByUserNameOrEmail(customer.userName, customer.email)
        return if (null != availableCustomer) {
            CommonResponse("EXISTS", "User already registered try login.")
        } else {
            customer.registeredDate = LocalDate.now();
            customerRepository.save(customer);
            CommonResponse("ADDED", "User registration successful.")
        }
    }

    fun authenticateCustomer(customer: Customer): AuthenticatedUser {
        var availableCustomer: Customer? = customerRepository.findCustomerByUserNameAndPassword(customer.userName, customer.password)
        return if (null == availableCustomer) {
            AuthenticatedUser()
        } else {
            var lastLoginDate: LocalDate? = availableCustomer.lastLogInDate
            availableCustomer.lastLogInDate = LocalDate.now()
            customerRepository.save(availableCustomer)
            AuthenticatedUser(availableCustomer.userName, availableCustomer.userType, true, availableCustomer.registeredDate, lastLoginDate)
        }
    }
}