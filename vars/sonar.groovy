import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def ProjectName = resultJson.pname
def ProjectKey = resultJson.pkey
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
        
   }""",*/ url: "http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectKey}&name=${ProjectName}"
}
	def call(){
def request = libraryResource 'data.json'
createRepo(request)
}
