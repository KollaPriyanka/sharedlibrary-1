import groovy.json.JsonSlurper 
@NonCPS

def call(message)
{
 println(message)
 def request = libraryResource 'sonarConnectorData.json'
 def jsonSlurper = new JsonSlurper() 
 def resultJson = jsonSlurper.parseText(request)
 def rpkey = resultJson.pkey
   sh " echo '${rid}' ${message} >>log.txt"
}
