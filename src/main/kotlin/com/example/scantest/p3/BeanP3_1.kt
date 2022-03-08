package com.example.spring

import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import com.example.scantest.inside.Type1

@Component
@ComponentScan (
    basePackageClasses = [ BeanP4_1::class ]
)
class BeanP3_1 : Type1