package groovykickstart.everyday

import groovy.json.JsonSlurper

def students = new XmlSlurper().parse(new File('src/main/resources/students.xml'))

assert students.student.course.size() == 6
assert students.student.find { it.@name == 'Jane' }.course.@hours*.toInteger().sum() == 37



def json ='[{"course": "Math", "score": 10}, {"course": "Chemistry", "score": 8}]'
def results= new JsonSlurper().parseText(json)

assert results.score.max() == 10