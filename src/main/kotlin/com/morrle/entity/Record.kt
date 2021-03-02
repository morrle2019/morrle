package com.morrle.entity

import com.morrle.entity.enums.RecordStatusEnum
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.DBRef
import java.time.LocalDateTime

data class Record(
    @Id
    val id: String? = null,

    var status: RecordStatusEnum = RecordStatusEnum.UNPUBLISHED,

    @DBRef
    var category: Category? = null,

    var tags: Set<String>? = null,

    var content: String? = null,

    @CreatedDate
    var createdDate: LocalDateTime? = null,

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null,

    var readingCount: Int = 0

)
