package net.will.gls.semantics.coercion

import org.junit.Test;

import groovy.test.GroovyAssert

class ClosureToTypeCoercionTest extends GroovyAssert {
    @Test
    void test_omitAsSinceGroovy2_2_0() {
        Predicate filter = { it.contains 'G' }
        assert filter.accept('Groovy') == true
        
        Greeter greeter = { 'Groovy' }
        greeter.greet()
    }
    
    boolean doFilter(String s) { 
        s.contains('G')
    }
    
    @Test
    void test_useMethodPointer() {
        Predicate filter = this.&doFilter
        assert filter.accept('Groovy') == true
        
        Greeter greeter = GroovySystem.&getVersion
        greeter.greet()
    }
    
    public <T> List<T> filter(List<T> source, Predicate<T> predicate) {
        source.findAll { predicate.accept(it) }
    }
    
    @Test
    void test_callingMethodWithClosure() {
        assert filter(['Java','Groovy']) { it.contains 'G'} == ['Groovy']
    }
    
    @Test
    void test_coerceClosureToInterface() {
        def impl = { println 'ok'; 123 } as IFooBar
        assert impl.foo() == 123
        impl.bar()
    }
    
    @Test
    void test_coerceClosureToAnyClass() {
        def impl = {
            println 'ok'
            println 'ok again'
            123
        } as IFooBar
        assert impl.foo() == 123
        impl.bar()
    }
    
    @Test
    void test_mapToType() {
        def x = [ f: {println "f called"} ] as X
        x.f()
        
        shouldFail(MissingMethodException.class) {
            x.g()
        }
        
        shouldFail(UnsupportedOperationException.class) {
            x.g(5)
        }
    }
    
    @Test
    void test_string2Enum() {
        State st = 'up'
        assert st == State.up
        
        shouldFail(IllegalArgumentException.class) {
            State st_error = 'not an enum value'
        }
    }
    
    State switchState(State st) {
        switch (st) {
            case 'up':
                return State.down // explicit constant
            case 'down':
                return 'up' // implicit coercion for return types
        }
    }
    
    @Test
    void test_string2Enum_ExplicitCoercionForMethodCall() {
        assert switchState('up' as State) == State.down
        assert switchState(State.down) == State.up
    }
    
}
