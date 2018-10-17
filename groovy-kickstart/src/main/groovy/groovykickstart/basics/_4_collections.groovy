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
// list.get(20) : IndexOutOfBoundsException
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
    return integers
}

//utility methods
list = [1, 2, 3]

assert list.first() == 1 //array method
assert list.head() == 1
assert list.tail() == [2, 3]
assert list.last() == 3  //array method
assert list.count(3) == 1
assert list.max() == 3
assert list.min() == 1
assert list.sum() == 6

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
assert map['object'] == 4

assert [:].size() == 0 //empty map literal


def students = [
        [name: "Jack", courses: [
                [name: "Math", hours: 10],
                [name: "Programming", hours: 20]]],
        [name: "John", courses: [
                [name: "Math", hours: 10],
                [name: "Databases", hours: 20]]],
        [name: "Jane", courses: [
                [name: "English", hours: 15],
                [name: "Physics", hours: 22]]]
]

//power stuff
assert [1, 2, 3, 4].findAll { it % 2 == 0 } == [2, 4]
assert [1, 2, 3, 4].collect { it * 2 } == [2, 4, 6, 8]
assert [1, 'a', new Object()].grep(String) == ['a']
assert students*.courses*.name.flatten().unique() == ['Math', 'Programming', 'Databases', 'English', 'Physics']