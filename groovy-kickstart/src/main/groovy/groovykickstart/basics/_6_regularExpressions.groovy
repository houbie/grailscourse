package groovykickstart.basics

import java.util.regex.Matcher
import java.util.regex.Pattern

String s = 'Groovy rocks!'

//pattern
assert ~/d+/ instanceof Pattern

//find operator =~
def roFinder = s =~ /ro(\w)/
def uFinder = s =~ /u/

assert roFinder.class == Matcher

if (roFinder){
    assert true
}else{
    assert false
}

assert !uFinder

assert roFinder.size() == 2
assert roFinder[0] == ['roo', 'o']
assert roFinder[1] == ['roc', 'c']


//match operator ==~
assert !(s ==~ /ro(\w)/)
assert s ==~ /Groovy \w+!/


//multiple assignment
def groovyJar = 'groovy-all-2.1.8.jar'
def (full, major, minor, revision) = (groovyJar =~ /(\d+)\.(\d+)\.(\d+)/)[0]

assert full == '2.1.8'
assert major == '2'
assert minor == '1'
assert revision == '8'
