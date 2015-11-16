package net.will.ggs.testingguide
class TranslationService {
    String convert(String key) {
        return "test"
    }
}

service = [convert: { String key -> 'some text' }] as TranslationService
assert 'some text' == service.convert('key.text')
