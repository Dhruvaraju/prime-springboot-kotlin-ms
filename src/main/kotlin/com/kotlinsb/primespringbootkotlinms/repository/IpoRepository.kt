package com.kotlinsb.primespringbootkotlinms.repository

import com.kotlinsb.primespringbootkotlinms.entities.IpoInformation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IpoRepository: JpaRepository<IpoInformation, Long> {
    fun findIpoInformationByUserName(userName: String?): List<IpoInformation?>?
}