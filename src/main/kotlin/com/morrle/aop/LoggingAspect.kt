package com.morrle.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*


@Aspect
@Component
class LoggingAspect {

    private val log: Logger = LoggerFactory.getLogger(LoggingAspect::class.java)


    @Pointcut(
        "within(@org.springframework.stereotype.Repository *)" +
                " || within(@org.springframework.stereotype.Service *)" +
                " || within(@org.springframework.web.bind.annotation.RestController *)"
    )
    fun springBeanPointcut() {
    }

    @Pointcut(
        "within(com.morrle.repository.*)" +
                " || within(com.morrle.service.*)" +
                " || within(com.morrle.controller.*)"
    )
    fun applicationPackagePointcut() {

    }

    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
    fun logAfterThrowing(joinPoint: JoinPoint, e: Throwable) {
        log.error(
            "Exception in {}.{}() with cause = {}", joinPoint.signature.declaringTypeName,
            joinPoint.signature.name, e.cause
        )
    }

    @Around("applicationPackagePointcut() && springBeanPointcut()")
    fun logAround(joinPoint: ProceedingJoinPoint): Any {
        if (log.isDebugEnabled) {
            log.debug(
                "Enter: {}.{}() with argument[s] = {}", joinPoint.signature.declaringTypeName,
                joinPoint.signature.name, Arrays.toString(joinPoint.args)
            )
        }
        return try {
            val result = joinPoint.proceed()
            if (log.isDebugEnabled) {
                log.debug(
                    "Exit: {}.{}() with result = {}", joinPoint.signature.declaringTypeName,
                    joinPoint.signature.name, result
                )
            }
            result
        } catch (e: IllegalArgumentException) {
            log.error(
                "Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.args),
                joinPoint.signature.declaringTypeName, joinPoint.signature.name
            )
            throw e
        }
    }


}