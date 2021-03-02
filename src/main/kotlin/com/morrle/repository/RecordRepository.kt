package com.morrle.repository

import com.morrle.entity.Record
import org.springframework.data.mongodb.repository.MongoRepository

interface RecordRepository: MongoRepository<Record, String> {
}