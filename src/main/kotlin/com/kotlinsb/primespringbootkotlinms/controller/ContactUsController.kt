package com.kotlinsb.primespringbootkotlinms.controller

import com.kotlinsb.primespringbootkotlinms.entities.ContactUs
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.service.ContactUsService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = ["/api/v1/messages"])
class ContactUsController(val contactUsService: ContactUsService) {
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    fun addMessage(@RequestBody userMessage: ContactUs): CommonResponse? {
        return contactUsService.addUserMessage(userMessage)
    }

    @RequestMapping(value = [""], method = [RequestMethod.GET])
    fun fetchAllUserMessages(): List<ContactUs?>? {
        return contactUsService.fetchAllMessages()
    }
}