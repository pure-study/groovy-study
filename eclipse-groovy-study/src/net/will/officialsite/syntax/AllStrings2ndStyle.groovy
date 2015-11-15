package net.will.officialsite.syntax

class AllStrings2ndStyle {

    static main(args) {
        method01()
        method02()
        method03()
    }
    static method01() {
        def sParameterLessClosure = "1 + 2 == ${-> 3}"
        assert sParameterLessClosure == '1 + 2 == 3'
    }
    static method02() {
        def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
        assert sOneParamClosure == '1 + 2 == 3'
    }
    static method03() {
        def number = 1
        def eagerGString = "value == ${number}"
        def lazyGString = "value == ${ -> number }"

        println eagerGString // "value == 1"
        println lazyGString  // "value == 1"

        number = 2
        println eagerGString // "value == 1"
        println lazyGString  // "value == 2"
    }
}
