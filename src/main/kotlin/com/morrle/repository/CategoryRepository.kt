package com.morrle.repository

import com.morrle.entity.Category
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepository: MongoRepository<Category, String> {
}