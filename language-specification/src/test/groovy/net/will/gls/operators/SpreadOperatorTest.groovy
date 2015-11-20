package net.will.gls.operators

import org.junit.Test;

class SpreadOperatorTest {
    @Test
    void testSpreadOperator_Basic() {
        def cars = [
            new Car(make: 'Peugeot', model: '508'),
            new Car(make: 'Renault', model: 'Clio')]
        
        def makes = cars*.make
        assert makes == ['Peugeot', 'Renault']
    }
    
    @Test
    void testSpreadOperator_WithNullElement() {
        def cars = [
                new Car(make: 'Peugeot', model: '508'),
                null,
                new Car(make: 'Renault', model: 'Clio')]
        
        assert cars*.make == ['Peugeot', null, 'Renault']
        assert null*.make == null
        assert null*.irrelevantProperty == null
    }
    
    @Test
    void testSpreadOperator_AnyIterableClass() {
        def composite = new CompositeObject()
        assert composite*.id == [1,2]
        assert composite*.name == ['Foo','Bar']
    }
    
    @Test
    void testSpreadingMethodArguments() {
        def args = [4, 5, 6]
        assert func(*args) == 26
        
        args = [4]
        assert func(*args, 5, 6) == 26
    }
    
    int func(int x, int y, int z) {
        x * y + z
    }
    
    @Test
    void testSpreadListElements() {
        def items = [4,5]
        def list = [1,2,3,*items,6]
        assert list == [1,2,3,4,5,6]
    }
    
    @Test
    void testSpreadMapElements_Basic() {
        def m1 = [c:3, d:4]
        def map = [a:1, b:2, *:m1]
        assert map == [a:1, b:2, c:3, d:4]
    }
    
    @Test
    void testSpreadMapElements_RelevantPosition_RedefinedKey() {
        def m1 = [c:3, d:4]
        def map = [a:1, b:2, *:m1, d:8]
        assert map == [a:1, b:2, c:3, d:8]
    }
}
