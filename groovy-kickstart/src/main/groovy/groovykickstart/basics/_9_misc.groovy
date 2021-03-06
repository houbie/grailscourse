package groovykickstart.basics

import javafx.beans.InvalidationListener
import javafx.beans.Observable as FxObservable

import javax.swing.SortingFocusTraversalPolicy as SFTP
import java.awt.*
import java.util.List
import java.util.Observable as JuObservable

print("Hello ") //System.out.print
println("world!") //System.out.println



//null-safe references
String s = "Hello", _null = null

assert s.toUpperCase().size() == 5
assert _null?.toUpperCase()?.size() == null




//elvis
s = _null ?: 'default'
assert s == 'default'

s = s ?: 'nope'
assert s == 'default'



class Person {
    String name
    List<Address> addresses
}
class Address {
    String city
}



//map constructor
def john = new Person(name: 'John', addresses: [new Address(city: 'NY'), new Address(city: 'Denver')])
def jack = new Person(name: 'Jack', addresses: [new Address(city: 'Detroit')])

//implicit constructor
Dimension area = [200, 100]
Dimension area2 = [width: 200, height: 100]
assert area == area2
assert area.width == 200
assert area.height == 100

//member access
assert john.name == john.getName()
assert john['name'] == 'John'
def field = 'name'
assert john[field] == 'John'



//spread operator
def numbers = [1, 2]
assert [0, *numbers] == [0, 1, 2]
assert Math.max(*numbers) == 2
//spread-dot operator
def persons = [john, jack]
assert persons*.name*.toUpperCase() == ['JOHN', 'JACK']
assert persons*.addresses*.city == [['NY', 'Denver'], ['Detroit']]

//methodMissing of collection (
assert persons.name == ['John', 'Jack']
//but:
assert persons.class == ArrayList
assert persons*.class.unique() == [Person]


//exceptions
void throwIt() { //not necessary to catch or declare checked exceptions like in Java
    throw new IOException()
}

try {
    throwIt()
    assert false
} catch (IOException | NullPointerException e1) { //multiple exceptions in one catch
    assert e1 instanceof IOException
} catch (e2) { //optional typing
    assert false
}



//default arguments
String toTable(def items, String separator = '|', int width = 10) {
    items.inject('') { table, value ->
        table << separator << value.toString().center(width) << separator << '\n'
    }
}

assert '\n' + toTable(['Groovy', 'Java'], '*', 16) == '''
*     Groovy     *
*      Java      *
'''

assert '\n' + toTable(['Groovy', 'Java'], '*') == '''
*  Groovy  *
*   Java   *
'''

assert '\n' + toTable(['Groovy', 'Java']) == '''
|  Groovy  |
|   Java   |
'''

assert '\n' + toTable(123) == '''
|   123    |
'''


//import aliasing
//shorter names
def sortingFocusTraversalPolicy = new SFTP({} as Comparator)

//resolve conflicts
class MyObservable extends JuObservable implements FxObservable{

    @Override
    void addListener(InvalidationListener listener) {

    }

    @Override
    void removeListener(InvalidationListener listener) {

    }
}