package net.will.officialsite.testingguide

class ClosureCoercion {

    static main(args) {
        BaseService service = { -> println 'doing something' }
        service.doSomething()
    }

}
