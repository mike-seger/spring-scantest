package com.example.spring

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import com.example.scantest.inside.Type1

@Component
@Profile("p2")
class BeanP4_2 : Type1