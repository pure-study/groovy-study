package net.will.ggs.testingguide.inclass

class ClosureCoercion {

    static main(args) {
        BaseService service = { -> println 'doing something' }
        service.doSomething()
    }

}
