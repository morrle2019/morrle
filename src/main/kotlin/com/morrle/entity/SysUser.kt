package com.morrle.entity

import org.springframework.data.annotation.Id

data class SysUser(
    @Id
    val id: String? = null,
    var username: String? = null,
    var password: String? = null
)
