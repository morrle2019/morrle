package com.morrle.service

import com.morrle.entity.SysUser
import com.morrle.repository.SysUserRepository
import org.springframework.stereotype.Service

@Service
class SysUserService(
    private val sysUserRepository: SysUserRepository
) {


    fun findByUsername(username: String): SysUser {

        return sysUserRepository.findByUsername(username);
    }


}