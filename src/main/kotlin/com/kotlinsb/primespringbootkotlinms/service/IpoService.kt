package com.kotlinsb.primespringbootkotlinms.service

import com.kotlinsb.primespringbootkotlinms.entities.IpoInformation
import com.kotlinsb.primespringbootkotlinms.model.CommonResponse
import com.kotlinsb.primespringbootkotlinms.repository.IpoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.math.roundToInt

@Service
class IpoService(val ipoRepo: IpoRepository) {
    fun addIpoDetails(ipoInfo: IpoInformation): CommonResponse? {
        ipoInfo.description = (ipoInfo.companyName + " is a market leader in its corresponding industry, with high industry standards."
                + "with a total market cap of " + ipoInfo.marketCap.roundToInt() + ". We are currently seeking an investment for expanding our industry presence in" +
                "different geographies.")
        ipoInfo.issueSize = (Math.round(Math.random() * 10000) + 100)
        ipoInfo.issuePrice = (ipoInfo.marketCap * ipoInfo.salePercentage / 100 / ipoInfo.issueSize)
        ipoInfo.lotSize = 10
        ipoInfo.issueDate = (LocalDate.now())
        ipoInfo.closingDate = (LocalDate.now().plusDays(5))
        ipoRepo.save(ipoInfo)
        return CommonResponse("ADDED", "IPO initiation Successful")
    }

    fun fetchIpoInitiatedByUser(userName: String?): List<IpoInformation?>? {
        return ipoRepo.findIpoInformationByUserName(userName)
    }
}