package myFirstKotlinSpringApp.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class MainController {

    val list: ArrayList<Int> = arrayListOf(1, 2, 3)

    @GetMapping("/")
    fun index() = list

    @GetMapping("/add")
    fun add(number: Int): Int {
        list.add(number)
        return number
    }

    @GetMapping("/remove")
    fun remove(index: Int): Int = list.removeAt(index)

}