package com.wanichnun.codewithbootkt.duck

abstract class Duck(private var flyBehavior : FlyBehavior, private var quackBehavior: QuackBehavior) {

    open fun performFly(): String {
        return flyBehavior.fly()
    }

    open fun performQuack(): String {
        return quackBehavior.quack()
    }
}

interface FlyBehavior {
    fun fly(): String
}

class FlyWithWings : FlyBehavior {
    override fun fly(): String {
        return "Fly with wings"
    }

}

class FlyWithAirplane : FlyBehavior {
    override fun fly(): String {
        return "Fly with airplane"
    }

}

interface QuackBehavior {
    fun quack(): String
}

class QuackSilence : QuackBehavior {
    override fun quack(): String {
        return "no quack"
    }

}

class QuackLoudly : QuackBehavior {
    override fun quack(): String {
        return "shout the quack!!"
    }

}

class SmallDuck : Duck(FlyWithWings(), QuackSilence())

class BigDuck : Duck(FlyWithAirplane(), QuackLoudly())
