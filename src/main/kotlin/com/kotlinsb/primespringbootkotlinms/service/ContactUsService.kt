package com.kotlinsb.primespringbootkotlinms.service

import com.kotlinsb.primespringbootkotlinms.entities.ContactUs
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.repository.ContactUsRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ContactUsService(val contactUsRepo: ContactUsRepository) {
    fun addUserMessage(userMessageInfo: ContactUs): CommonResponse? {
        userMessageInfo.messageDate = LocalDate.now()
        contactUsRepo.save(userMessageInfo)
        return CommonResponse("ADDED", "Message updated successfully.")
    }

    fun fetchAllMessages(): List<ContactUs?>? {
        return contactUsRepo.findAll()
    }
}