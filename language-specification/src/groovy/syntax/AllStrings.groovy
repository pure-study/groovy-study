assert 'ab' == 'a' + 'b'
//assert 'abc' == 'a' + 'b'

// -----------------
strippedFirstNewline = '''\
line one
line two
line three
'''

assert !strippedFirstNewline.startsWith('\n')

// -----------------
person = [name: 'Guillaume', age: 36]
assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'
assert '${name}' == "\${name}"


