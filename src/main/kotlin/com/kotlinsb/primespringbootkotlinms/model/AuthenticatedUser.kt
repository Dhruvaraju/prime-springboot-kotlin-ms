package com.kotlinsb.primespringbootkotlinms.model

import java.time.LocalDate

data class AuthenticatedUser(
        val userName: String? = null,
        val userType: String? = null,
        val authenticated: Boolean = false,
        val userFrom: LocalDate? = null,
        val lastLoginDate: LocalDate? = null
)
