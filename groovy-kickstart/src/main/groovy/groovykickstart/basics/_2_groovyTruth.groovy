package groovykickstart.basics

assert true
assert !false

int one = 1, zero = 0
assert one
assert !zero

assert [1, 2, 3]
assert ![]
assert ![:]

Object object = new Object(), _null = null
assert object
assert !_null

assert 'string'
assert !''
assert ' '

//generic
assert [].asType(Boolean) == false

//dynamic range
int i = 10
assert 1..i == 1..10
