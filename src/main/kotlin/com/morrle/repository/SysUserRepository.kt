package com.morrle.repository

import com.morrle.entity.SysUser
import org.springframework.data.mongodb.repository.MongoRepository

interface SysUserRepository : MongoRepository<SysUser, String> {

    fun findByUsername(username: String): SysUser

}