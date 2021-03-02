package com.morrle.entity

import com.morrle.entity.enums.WebsiteTypeEnum
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class Website(
    @Id
    val id: String? = null,
    var name: String? = null,
    var link: String? = null,
    var type: WebsiteTypeEnum = WebsiteTypeEnum.COMMON,
    @CreatedDate
    var createdDate: LocalDateTime? = null

)
