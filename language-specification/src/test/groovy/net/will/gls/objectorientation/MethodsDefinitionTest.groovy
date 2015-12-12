package net.will.gls.objectorientation

import groovy.test.GroovyAssert

import org.junit.Test

class MethodsDefinitionTest extends GroovyAssert {
    @Test
    void testNamedArguments() {
        def retval = MethodsDefinition.fooWithNamedArguments(name: 'Marie', age: 1)
        assert retval == "Marie: 1"
    }
    
    @Test
    void testDefaultArguments() {
        def retval = MethodsDefinition.fooWithDefaultArguments('Marie')
        assert retval.age == 1
    }
    
    @Test
    void testVarargs_Normal() {
        def md = new MethodsDefinition()
        assert md.fooVarargsNormal() == 0
        assert md.fooVarargsNormal(1) == 1
        assert md.fooVarargsNormal(5, 6) == 2
        
        shouldFail {
            assert md.fooVarargsNormal(null) == 0
        }
    }
    
    @Test
    void testVarargs_Array() {
        def md = new MethodsDefinition()
        assert md.fooVarargsArray() == 0
        assert md.fooVarargsArray(1) == 1
        assert md.fooVarargsArray(5, 6) == 2
        
        shouldFail {
            assert md.fooVarargsArray(null) == 0
        }
    }
    
    // Use UTF-8.
    @Test
    void testVarargsNull_Normal() {
        def md = new MethodsDefinition()
        
        // If a method with varargs is called with null as the vararg parameter, 
        // then the argument will be null and not an array of length one with 
        // null as the only element.
        // 如果以null值作为参数去调用一个可变参方法，那么这个方法接收到的参数就是null，
        // 而不是一个长度为1，包含惟一一个元素(它的值为null)的数组。
        assert md.fooVarargsReturnNormal(null) == null

        // If a varargs method is called with an array as an argument, then the 
        // argument will be that array instead of an array of length one 
        // containing the given array as the only element.
        // 如果以一个数组作为参数去调用一个可变参方法，那么这个数组所有元素分别作为
        // 参数传给这个方法，而不是作为一个整体的参数传给这个方法。换句话说，这个数
        // 组有多少个元素，这个方法就接收到了多少个参数。
        Integer[] ints = [1, 2]
        assert md.fooVarargsReturnNormal(ints) == [1, 2]
    }
    
    @Test
    void testVarargsOverloading() {
        def md = new MethodsDefinition()
        assert md.varargsOverloading() == 1
        assert md.varargsOverloading(1) == 2
        assert md.varargsOverloading(1, 2) == 1
    }
}
