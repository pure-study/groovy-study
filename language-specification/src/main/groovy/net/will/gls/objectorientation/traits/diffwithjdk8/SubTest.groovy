package net.will.gls.objectorientation.traits.diffwithjdk8

class SubTest extends FatherTest implements MyTestSupport {
    void callSomeMethod() {
        println someMethod()
    }
}
