import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def QualityGateName = resultJson.qname
def credentials = resultJson.cname
//def projUrl = resultJson.url

httpRequest authentication: '${credentials}', contentType: "APPLICATION_JSON", 
    
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
        
   }""",*/ url: "http://3.16.33.107:9000/api/qualitygates/create?name=${QualityGateName}"
}
	def call(){
def request = libraryResource 'sonarConnectorData.json'
createRepo(request)
}
