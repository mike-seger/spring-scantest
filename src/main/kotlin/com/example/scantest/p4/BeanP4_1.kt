package com.example.spring

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import com.example.scantest.inside.Type1

@Component
@ComponentScan (
    basePackageClasses = [ BeanP4_1::class ]
)
@Profile("p1")
class BeanP4_1 : Type1