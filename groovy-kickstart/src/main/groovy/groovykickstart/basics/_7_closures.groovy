package groovykickstart.basics

Closure<Boolean> isOdd = { Number number -> return number % 2 != 0 }

assert isOdd.call(3)
assert isOdd(3)

//closure as argument
List filter(List list, Closure predicate) {
    List result = []
    for (element in list) {
        if (predicate(element)) {
            result << element
        }
    }
    return result
}

def list = [1, 2, 3, 4]
assert filter(list, isOdd) == [1, 3]

//anonymous closure
filter(list, { Number number -> return number % 2 != 0 })
filter(list) { Number number -> return number % 2 != 0 }

//GDK methods
list.findAll({ Number number -> return number % 2 != 0 })

//simplified syntax
list.findAll() { Number number -> return number % 2 != 0 }
list.findAll { Number number -> return number % 2 != 0 }
list.findAll { return it % 2 != 0 }
list.findAll { it % 2 != 0 }
list.findAll { it % 2 }

assert list.findAll { it % 2 } == [1, 3]

//scope
class VarScope {
    String classVar = 'class variable'

    String scopeAccess(arg) {
        String localVar = ''
        1.upto(2) {
            localVar += "$it: $arg, $classVar "
        }
        return localVar
    }

    String overridingScopeAccess(arg) {
        String localVar = ''
        1.upto(2) {
            //String arg, localVar ->compilation error
            String classVar = 'closure local classVar'
            localVar += "$it: $arg, $classVar "
        }
        return localVar
    }
}

assert new VarScope().scopeAccess('argument') == '1: argument, class variable 2: argument, class variable '
assert new VarScope().overridingScopeAccess('argument') == '1: argument, closure local classVar 2: argument, closure local classVar '

//methods can be used as closures
def func = new VarScope().&overridingScopeAccess
assert func('argument') == '1: argument, closure local classVar 2: argument, closure local classVar '



//collections and closures are a natural match
assert list.find { it % 2 == 0 } == 2
assert list.collect { it * it } == [1, 4, 9, 16]
assert list.inject(1) { fac, item -> fac * item } == 1 * 1 * 2 * 3 * 4
assert [1, 3, 4, 2].sort() == [1, 2, 3, 4] //natural sort
assert list.sort { it % 2 } == [2, 4, 1, 3]
assert list.every { item -> item < 5 } //predicate holds for every item
assert list.any { item -> item < 2 }   //predicate holds for at least one item


list = [1, 2, 3, 4]
def result = ''
list.each { result += it + ' ' }
assert result == '1 2 3 4 '

result = ''
list.reverseEach { result += it + ' ' }
assert result == '4 3 2 1 '

result = ''
list.eachWithIndex { item, index ->
    result += "$index:$item "
}
assert result=='0:1 1:2 2:3 3:4 '

//map equivalents
def map = [a: 1, b: 2, c: 3]
map.each { entry -> println "$entry.key : $entry.value" }
map.each { key, value -> println "$key : $value" }



//iteration with closures
1.upto(3) { println it }

def s = ''
2.downto(-1) { i -> s = s << i << ', ' }
assert s.toString() == '2, 1, 0, -1, '

s = ''
10.times { s += 'x' }
assert s == 'x' * 10

s = ''
0.step(0.5, 0.1) { s += it + ' ' }
assert s == '0 0.1 0.2 0.3 0.4 '

s = ''
['a', 'b', 'c'].each { s += it }
assert s == 'abc'


//array literals conflict with closures
//int[] array= {1,2,3} //syntax error
int[] array = [1, 2, 3] //automatic type coercion
assert array.size() == 3





//returning from closure is NOT equivalent with break in loop!!!
//find index of element in list with for loop
list = [2, 3, 1, 4, 1]

int findIndex(list, element) {
    for (int i = 0; i < list.size(); i++) {
        if (list[i] == element) {
            return i
        }
    }
    return -1
}

assert findIndex(list, 1) == 2

//implementation with each
int findIndexGroovy(list, element) {
    list.eachWithIndex { el, i ->
        if (el == element) {
            return i
        }
    }
    return -1
}

assert findIndexGroovy(list, 1) == -1
