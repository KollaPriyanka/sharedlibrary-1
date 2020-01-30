import groovy.json.JsonSlurper 

@NonCPS
createProject(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def ProjectName = resultJson.pname
def ProjectKey = resultJson.pkey
//def projUrl = resultJson.url

httpRequest authentication: 'sonar_credentials', contentType: "APPLICATION_JSON", 
    
    httpMode: 'POST',  url: "http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectName}&name=${ProjectKey}"
}
	def call(){
def request = libraryResource 'sonarConnectorData.json'
createProject(request)
//createQualityGate(request)		
}
