package net.will.gls.operators

import org.junit.Test;

class MembershipOperatorTest {
    @Test
    void testMembershipOperator() {
        def list = ['Grace','Rob','Emmy']
        assert ('Emmy' in list)  // equivalent to calling list.contains('Emmy') or list.isCase('Emmy')
    }
}
