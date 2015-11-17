package net.will.gls.syntax

import org.junit.Test;

class IntegralLiteralsTest extends groovy.test.GroovyAssert {
    @Test
    void testPositiveNubmers() {
        def a = 1
        assert a instanceof Integer
        
        // Integer.MAX_VALUE
        def b = 2147483647
        assert b instanceof Integer
        
        // Integer.MAX_VALUE + 1
        def c = 2147483648
        assert c instanceof Long
        
        // Long.MAX_VALUE
        def d = 9223372036854775807
        assert d instanceof Long
        
        // Long.MAX_VALUE + 1
        def e = 9223372036854775808
        assert e instanceof BigInteger
    }
    
    @Test
    void testNegativeNubmers() {
        def na = -1
        assert na instanceof Integer
        
        // Integer.MIN_VALUE
        def nb = -2147483648
        assert nb instanceof Integer
        
        // Integer.MIN_VALUE - 1
        def nc = -2147483649
        assert nc instanceof Long
        
        // Long.MIN_VALUE
        def nd = -9223372036854775808
        assert nd instanceof Long
        
        // Long.MIN_VALUE - 1
        def ne = -9223372036854775809
        assert ne instanceof BigInteger
    }
    
    @Test
    void testNubmers_EdgeCases() {
        def c = Integer.MAX_VALUE + 1
        shouldFail {
            assert c instanceof Long
        }
        assert c instanceof Integer
        
        def nc = Integer.MIN_VALUE - 1
        shouldFail {
            assert c instanceof Long
        }
        assert c instanceof Integer
    }
    
    @Test
    void testBinaryLiteral() {
        int xInt = 0b10101111
        assert xInt == 175
        
        short xShort = 0b11001001
        assert xShort == 201 as short
        
        byte xByte = 0b11
        assert xByte == 3 as byte
        
        long xLong = 0b101101101101
        assert xLong == 2925l
        
        BigInteger xBigInteger = 0b111100100001
        assert xBigInteger == 3873g
        
        int xNegativeInt = -0b10101111
        assert xNegativeInt == -175
    }
    
    @Test
    void testOctalLiteral() {
        int xInt = 077
        assert xInt == 63
        
        short xShort = 011
        assert xShort == 9 as short
        
        byte xByte = 032
        assert xByte == 26 as byte
        
        long xLong = 0246
        assert xLong == 166l
        
        BigInteger xBigInteger = 01111
        assert xBigInteger == 585g
        
        int xNegativeInt = -077
        assert xNegativeInt == -63
    }
    
    @Test
    void testHexadecimalLiteral() {
        int xInt = 0x77
        assert xInt == 119
        
        short xShort = 0xaa
        assert xShort == 170 as short
        
        byte xByte = 0x3a
        assert xByte == 58 as byte
        
        long xLong = 0xffff
        assert xLong == 65535l
        
        BigInteger xBigInteger = 0xaaaa
        assert xBigInteger == 43690g
        
        Double xDouble = new Double('0x1.0p0')
        assert xDouble == 1.0d
        
        int xNegativeInt = -0x77
        assert xNegativeInt == -119
    }
}
