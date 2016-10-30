package net.will.gls.closures.delegationstrategy.owner

class EnclosedInInnerClass {
    class Inner {
        Closure cl = {
            owner
        }
    }
}
