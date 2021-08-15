package com.kotlinsb.primespringbootkotlinms.controller

import com.kotlinsb.primespringbootkotlinms.entities.IpoInformation
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.service.IpoService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = ["api/v1/ipo"])
class IpoController(val ipoService: IpoService) {
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    fun registerIpo(@RequestBody ipoInfo: IpoInformation): CommonResponse? {
        return ipoService.addIpoDetails(ipoInfo)
    }

    @RequestMapping(value = ["/{userName}"], method = [RequestMethod.GET])
    fun fetchIposByUserName(@PathVariable userName: String?): List<IpoInformation?>? {
        return ipoService.fetchIpoInitiatedByUser(userName)
    }
}