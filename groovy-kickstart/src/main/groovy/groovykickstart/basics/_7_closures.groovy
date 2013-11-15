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

assert list.findAll { it % 2 } == [1, 3]
1.upto(3) { println it }


def s = ''
2.downto(1) { s = s << it << ', ' }
assert s.toString() == '2, 1, '

assert ((1..3 as List) + (2..1 as List)).join(', ') == '1, 2, 3, 2, 1'

//array literals conflict with closures
//int[] array= {1,2,3} //syntax error
int[] array = [1, 2, 3] //automatic type coercion
assert array.size() == 3
