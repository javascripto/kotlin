package com.yuri.KotlinSpring

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinSpringApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringApplication>(*args)
}
