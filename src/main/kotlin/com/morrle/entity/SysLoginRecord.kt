package com.morrle.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class SysLoginRecord(
    @Id
    val id: String? = null,
    var ip: String? = null,
    var userAgent: String? = null,
    var loginDateTime: LocalDateTime? = null

)
