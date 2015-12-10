package net.will.gls.structure

import static Calendar.getInstance as now

import org.junit.Test

class ImportAliasingTest {
    @Test
    void testStaticImportAliasing() {
        assert now().class == Calendar.getInstance().class
    }
    
    @Test
    void testImportAliasing_FixThirdPartyLib() {
        def multiplylib = new MultiplyTwo()
        
        assert 4 == new MultiplyTwo().multiply(2)
    }
}
