package com.morrle.entity

import org.springframework.data.annotation.Id

data class Category(
    @Id
    val id: String? = null,

    var title: String? = null

)
