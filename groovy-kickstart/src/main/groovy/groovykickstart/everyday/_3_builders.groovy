package groovykickstart.everyday

import groovy.xml.MarkupBuilder


assert new File('src/main/resources/hello.txt').text == 'Hello Groovy!\n'

File tmpFile = File.createTempFile('hello', 'tmp')
tmpFile.text = 'Hello world!\n'
tmpFile << 'Groovy baby\n'

InputStream inputStream = tmpFile.newInputStream()
assert inputStream.readLines() == ['Hello world!', 'Groovy baby']

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
builder.persons {
    person(gender: 'M') {
        name('John')
    }
    person(gender: 'F') {
        name('Alice')
    }
}

assert '\n' + writer.toString() == '''
<persons>
  <person gender='M'>
    <name>John</name>
  </person>
  <person gender='F'>
    <name>Alice</name>
  </person>
</persons>'''



