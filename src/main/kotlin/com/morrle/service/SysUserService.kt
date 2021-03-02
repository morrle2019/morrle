package com.morrle.service

import com.morrle.entity.SysUser
import com.morrle.repository.SysUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SysUserService {

    @Autowired
    private lateinit var sysUserRepository: SysUserRepository


    fun findByUsername(username: String): SysUser {

        return sysUserRepository.findByUsername(username);
    }


}