@file:Suppress("unused")

package com.example.scantest.inside

import com.example.spring.BeanP1_1
import com.example.spring.BeanP2_1
import com.example.spring.BeanP3_1
import com.example.spring.BeanP4_1
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

@SpringBootApplication(
	scanBasePackageClasses = [
		ScantestApplication::class,
		BeanP1_1::class,
	]
)
@Import(BeanP2_1::class, BeanP3_1::class, BeanP4_1::class)
class ScantestApplication(var beans: Set<Type1>, var props: DynamoConfigProperties) : CommandLineRunner {
	private val log = LoggerFactory.getLogger(ScantestApplication::class.java)

	override fun run(vararg args: String?) {
		log.info("run")
		var sb = StringBuilder()
		for (option in args) {
			sb.append(" ").append(option)
			log.info("OPTION: {}", option)
		}
		sb = sb.ifEmpty { sb.append("No Options Specified") }
		log.info("\nJAR launched with the following options: $sb")

		sb = StringBuilder()
		sb.append("\nBeans\n")
		beans.map { it.javaClass.simpleName }.sorted().forEach { sb.append("      $it\n") }
		sb.append("\nProps:\n${props.toString().replace(",", ",\n").prependIndent("    ")}")
		log.info(sb.toString())
	}
}

interface Type1

@Component
class Bean1 : Type1

fun main(args: Array<String>) {
	SpringApplication.run(ScantestApplication::class.java, *args)
}
