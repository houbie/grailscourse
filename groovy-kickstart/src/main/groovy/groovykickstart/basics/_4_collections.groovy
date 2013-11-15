package groovykickstart.basics

import groovy.transform.TypeChecked

List list = [0, 1, 2]

//indexed access
assert list[2] == 2

//range access
assert list[0..1] == [0, 1]

//leftShift operator
list << 3
assert list == [0, 1, 2, 3]

//plus operator
list += [4, 5]
assert list == [0, 1, 2, 3, 4, 5]

//multiply operator
assert [1, 2] * 2 == [1, 2, 1, 2]

//automatic expansion
list[10] = 10
assert list.size() == 11
assert list[6..9] == [null] * 4

//shrink
list[0..9] = []
assert list == [10]

//generics are broken without TypeChecked
List<Integer> integers = [1, 2, 3]
integers << 'string'
integers.add('another')
assert integers == [1, 2, 3, 'string', 'another']

@TypeChecked
List<Integer> genericsFunction() {
    List<Integer> integers = [1, 2, 3]
    //following will cause compilation error
    //integers << 'string'
    expect:
    return integers
}



//maps
Object object = new Object()
def map = [key1: 1, 'key 2': 2, (object): 3, object: 4]
assert map.keySet().containsAll(['key1', 'key 2', object, 'object'])

assert map.key1 == 1
assert map.'key 2' == 2
assert map.object == 4

assert map['key1'] == 1
assert map['key 2'] == 2
assert map[object] == 3
