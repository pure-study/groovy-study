package net.will.gls.operators

import org.junit.Test

import net.will.gls.operators.subscriptop.User

class SubscriptOperatorTest {
    @Test
    void testSubscriptOperator_Basic() {
        def list = [0,1,2,3,4]
        assert list[2] == 2
        
        list[2] = 4
        assert list[0..2] == [0,1,4]
        
        list[0..2] = [6,6,6]
        assert list == [6,6,6,3,4]
    }
    
    @Test
    void testCustomImplementationOfGetAtPutAt() {
        def user = new User(id: 1, name: 'Alex')
        assert user[0] == 1
        assert user[1] == 'Alex'
        
        user[0] = 2
        user[1] = 'Bob'
        assert user.id == 2
        assert user.name == 'Bob'
    }
}
