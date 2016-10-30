package net.will.gls.closures.delegationstrategy.meaningofthis

import groovy.lang.Closure;

class EnclosedInInnerClass {
    class Inner {
        Closure cl = { this }
    }
}
