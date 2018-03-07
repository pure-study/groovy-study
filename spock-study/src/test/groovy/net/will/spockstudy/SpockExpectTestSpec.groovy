package net.will.spockstudy

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class SpockExpectTestSpec extends Specification {
    @Ignore("some message")
    @Unroll
    def "judgement test on #someInputMsg"() {
        expect:
        someInputMsg

        where:
        someInputMsg << ['', 'Success', 'Exception: some message']
    }

    @Unroll
    def "test2 on #someInputMsg"() {
        expect:
        someInputMsg

        where:
        someInputMsg << ['1', '2', '3']
    }
}
