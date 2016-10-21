package net.will.gls.objectorientation.traits.diffwithjdk8

import static org.junit.Assert.*;

import org.junit.Test;

class DiffWithJdk8DefaultMethodTest {

    @Test
    public void test() {
        SubTest obj = new SubTest()
        obj.callSomeMethod()
        
        assert obj.someMethod() == "This is in Trait - MyTestSupport"
    }

}
