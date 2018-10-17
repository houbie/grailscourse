package groovykickstart.everyday

assert new File('src/main/resources/hello.txt').text == 'Hello Groovy!'

File tmpFile = File.createTempFile('hello', 'tmp')
tmpFile.text = 'Hello world!\n'
tmpFile << 'Groovy baby\n'

InputStream inputStream = tmpFile.newInputStream()
assert inputStream.readLines() == ['Hello world!', 'Groovy baby']

