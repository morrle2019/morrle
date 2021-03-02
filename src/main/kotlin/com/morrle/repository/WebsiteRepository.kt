package com.morrle.repository

import com.morrle.entity.Website
import org.springframework.data.mongodb.repository.MongoRepository

interface WebsiteRepository: MongoRepository<Website, String> {

}