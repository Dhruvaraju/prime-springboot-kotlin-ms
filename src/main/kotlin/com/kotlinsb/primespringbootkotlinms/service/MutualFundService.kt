package com.kotlinsb.primespringbootkotlinms.service

import com.kotlinsb.primespringbootkotlinms.entities.MutualFund
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.repository.MutualFundRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MutualFundService( val mutualFundRepo : MutualFundRepository) {
    fun registerMutualFund(mutualFund: MutualFund): CommonResponse? {
        mutualFund.registrationDate = LocalDate.now()
        mutualFundRepo.save(mutualFund)
        return CommonResponse("ADDED", "Mutual Fund registration successful.")
    }

    fun fetchMutualFundsOwnedByUser(userName: String?): List<MutualFund?>? {
        return mutualFundRepo.findMutualFundByUserName(userName)
    }
}