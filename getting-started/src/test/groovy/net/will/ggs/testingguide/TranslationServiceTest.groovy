package net.will.ggs.testingguide

import org.junit.Test;

class TranslationServiceTest {
    @Test
    void testConvert_RealOperation() {
        TranslationService service = new TranslationService()
        assert 'test' == service.convert('key.text')
    }
    
    @Test
    void testConvertWithClosureCoercion() {
        TranslationService service = { String key -> 'some text' } as TranslationService
        assert 'some text' == service.convert('key.text')
    }
    
    @Test
    void testConvertWithMapCoercion() {
        TranslationService service = [convert: { String key -> 'some text' }] as TranslationService
        assert 'some text' == service.convert('key.text')
    }
}
