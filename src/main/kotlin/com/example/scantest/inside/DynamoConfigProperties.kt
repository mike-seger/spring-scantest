package com.example.scantest.inside

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "props.dynamo")
@PropertySource(value = ["classpath:/config.yaml"], factory = YamlPropertySourceFactory::class)
data class DynamoConfigProperties(
    var customerTableName: String = "",
    var region: String = "",
    var endpoint: String = ""
)
