package net.will.gls.semantics

import org.junit.Test;

import groovy.test.GroovyAssert;

class AssignmentTest extends GroovyAssert {
    @Test
    void multipleAssignmentTest() {
        def (_, month, year) = "18th June 2009".split()
        assert "In $month of $year" == 'In June of 2009'
    }
}
