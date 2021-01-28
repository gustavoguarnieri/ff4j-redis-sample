package com.example.ff4jredissample.controller

import com.example.ff4jredissample.enums.FeatureFlag
import org.ff4j.FF4j
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/foo")
class Foo(
    @Qualifier("getFF4j") private val ff4j: FF4j
) {

    @GetMapping
    fun getFoo(): String {
        return if(ff4j.check(FeatureFlag.FEATURE_A.name)){
            "Hello new feature !!!"
        } else {
            "Hello !!!"
        }
    }
}