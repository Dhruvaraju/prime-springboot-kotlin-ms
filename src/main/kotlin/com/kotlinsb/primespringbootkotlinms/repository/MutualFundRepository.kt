package com.kotlinsb.primespringbootkotlinms.repository

import com.kotlinsb.primespringbootkotlinms.entities.MutualFund
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MutualFundRepository: JpaRepository<MutualFund, Long> {
    fun findMutualFundByUserName(userName: String?): List<MutualFund?>?
}