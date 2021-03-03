package com.morrle.repository

import com.morrle.entity.SysLoginRecord
import org.springframework.data.mongodb.repository.MongoRepository

interface SysLoginRecordRepository : MongoRepository<SysLoginRecord, String> {
}