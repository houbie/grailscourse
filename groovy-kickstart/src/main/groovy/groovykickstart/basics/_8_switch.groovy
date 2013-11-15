package groovykickstart.basics

def o = new Object()
def objects = [o, 1, 10000, 3.2, 'hello', 'world', 'foo', [key: 'value']]
def hellos = [], woes = [], strings = [], inRange = [], bigNumbers = [], numbers = [], inList = [], object = []
for (obj in objects) {

    switch (obj) {
        case 'hello':
            hellos << obj
            break
        case ~/wo.+/:
            woes << obj
            break
        case String:
            strings << obj
            break
        case 0..10:
            inRange << obj
            break
        case { (it instanceof Number) ? it > 1000 : false }:
            bigNumbers << obj
            break
        case Number:
            numbers << obj
            break
        case o:
            object << obj
            break
        case [o, 3, [key: 'value']]:
            inList << obj
            break
        default: assert false
    }

}

assert hellos == ['hello']
assert woes == ['world']
assert strings == ['foo']
assert inRange == [1]
assert bigNumbers == [10000]
assert numbers == [3.2]
assert object == [o]
assert inList == [[key: 'value']]

def pattern = ~/wo.+/
assert pattern.isCase('world')

assert objects.grep(~/wo.+/) == objects.findAll { it==~/wo.+/ }
assert objects.grep(String) == objects.findAll { it instanceof String }