package com.wanichnun.codewithbootkt.duck

import com.wanichnun.codewithbootkt.duck.BigDuck
import com.wanichnun.codewithbootkt.duck.SmallDuck
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DuckTest {
    @Test
    fun smallDuckTest() {
        val smallDuck = SmallDuck()
        assertEquals("Fly with wings", smallDuck.performFly(), "Wrong flying method")
        assertEquals("no quack", smallDuck.performQuack(), "Wrong quacking method")
    }

    @Test
    fun bigDuckTest() {
        val bigDuck = BigDuck()
        assertEquals("Fly with airplane", bigDuck.performFly(), "Wrong flying method")
        assertEquals("shout the quack!!", bigDuck.performQuack(), "Wrong quacking method")
    }
}