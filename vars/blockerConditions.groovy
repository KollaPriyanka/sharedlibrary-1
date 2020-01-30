import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def GateId = resultJson.gateid
//def rid = resultJson.id
//def projUrl = resultJson.url

httpRequest authentication: 'sonar_credentials', contentType: "APPLICATION_JSON", 
    
    httpMode: 'POST',/* requestBody: 
  """{
    	"data":
	{
		"repoType": "hosted",
        "id": ${rid},
        "name": ${repoName},
        "repoPolicy": "RELEASE",
        "provider": "maven2",
        "providerRole": "org.sonatype.nexus.proxy.repository.Repository",
        "exposed": true,
        "format": "maven2"
	}
        
   }""",*/ url: "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=$(GateId)&metric=blocker_violations&op=GT&warning=5&error=10"
}
	def call(){
def request = libraryResource 'sonarConnectorData.json'
createRepo(request)
}
