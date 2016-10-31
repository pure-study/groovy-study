package net.will.gls.closures

import org.junit.Test;

import groovy.test.GroovyAssert

class CurryingTest extends GroovyAssert {
    @Test
    void leftCurryingTest() {
        def nCopies = { int n, String str -> str*n }
        def twice = nCopies.curry(2)
        assert twice('bla') == 'blabla'
        assert twice('bla') == nCopies(2, 'bla')
    }
    
    @Test
    void rightCurringTest() {
        def nCopies = { int n, String str -> str*n }
        def blah = nCopies.rcurry('bla')
        assert blah(2) == 'blabla'
        assert blah(2) == nCopies(2, 'bla')
    }
    
    @Test
    void IndexBasedCurryingTest() {
        def volume = { double l, double w, double h -> l*w*h }
        def fixedWidthVolume = volume.ncurry(1, 2d)
        assert volume(3d, 2d, 4d) == fixedWidthVolume(3d, 4d)
        def fixedWidthAndHeight = volume.ncurry(1, 2d, 4d)
        assert volume(3d, 2d, 4d) == fixedWidthAndHeight(3d)
    }
}
