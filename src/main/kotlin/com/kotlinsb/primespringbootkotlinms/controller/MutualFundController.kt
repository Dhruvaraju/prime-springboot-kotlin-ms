package com.kotlinsb.primespringbootkotlinms.controller

import com.kotlinsb.primespringbootkotlinms.entities.MutualFund
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.service.MutualFundService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping(value = ["/api/v1/mutual-fund"])
class MutualFundController(val mutualFundService: MutualFundService) {
    @RequestMapping(value = ["/register"], method = [RequestMethod.POST])
    fun registerMutualFund(@RequestBody mutualFund: MutualFund): CommonResponse? {
        return mutualFundService.registerMutualFund(mutualFund)
    }

    @RequestMapping(value = ["/{userName}"], method = [RequestMethod.GET])
    fun fetchUserMutualFunds(@PathVariable userName: String?): List<MutualFund?>? {
        return mutualFundService.fetchMutualFundsOwnedByUser(userName)
    }
}