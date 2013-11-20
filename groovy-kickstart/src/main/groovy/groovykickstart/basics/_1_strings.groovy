package groovykickstart.basics

def doubleQuoted = "hello"
def singleQuoted = 'hello'
def slashed = /hello/

assert doubleQuoted == singleQuoted
assert doubleQuoted == slashed
assert doubleQuoted.class == String
assert singleQuoted.class == String
assert slashed.class == String


def name = 'world'
assert "hello $name" == 'hello world'
assert "hello $name" instanceof GString

assert "hello ${name.toUpperCase()}, ${1 + 1} times" == 'hello WORLD, 2 times'
assert 'hello world' == /hello $name/

assert "hello \$name" == 'hello $name'

assert name.length() == name.size()

assert 'tab:\t backslash:\\ double quote:" single quote:\'' == "tab:\t backslash:\\ double quote:\" single quote:'"
assert (/tab:\u0009 backslash:\ double quote:" single quote:'/) == "tab:\t backslash:\\ double quote:\" single quote:'"


assert '''preserve

           newlines
           ''' == 'preserve\n\n           newlines\n           '

assert """hello

           $name""" == 'hello\n\n           world'



char character = 'a'
assert character.class == Character
assert 'a'.class == String

//changing strings
def greeting = 'Hello'
greeting <<= ' world'
assert greeting.class == StringBuffer
greeting << '!'
assert greeting.toString() == 'Hello world!'

greeting[6..9] = 'da' //replace 'worl' with 'da'
assert greeting.toString() == 'Hello dad!'

//String operations
greeting = 'Hello Groovy!'
assert greeting[0] == 'H'
assert greeting[6..-2] == 'Groovy'
assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!'
assert greeting.count('o') == 3
assert 'x'.padLeft(3) == '  x'
assert 'x'.padRight(3, '_') == 'x__'
assert 'x'.center(3) == ' x '
assert 'x' * 3 == 'xxx'