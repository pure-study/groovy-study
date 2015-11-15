class TranslationService2 {
    String convert(String key) {
        return "test"
    }
}

service = { String key -> 'some text' } as TranslationService2
assert 'some text' == service.convert('key.text')

//BaseService service = { -> println 'doing something' }
//service.doSomething()
