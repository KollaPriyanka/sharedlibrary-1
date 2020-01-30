import groovy.json.JsonSlurper 

@NonCPS
createRepo(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def ProjectName = resultJson.pname
def ProjectKey = resultJson.pkey
def QualityGateName = resultJson.qname
def GateId = resultJson.gateid
def ProjectId = resultJson.projectid
//def projUrl = resultJson.url

httpRequest authentication: 'sonar_credentials', contentType: "APPLICATION_JSON", 
    
    httpMode: 'POST', url: "http://ec2-3-16-33-107.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=${ProjectKey}&name=${ProjectName}", url: "http://3.16.33.107:9000/api/qualitygates/create?name=${QualityGateName}", url: "http://3.16.33.107:9000/api/qualitygates/list", url: "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=${GateId}&metric=blocker_violations&op=GT&warning=5&error=10", url: "http://3.16.33.107:9000/api/qualitygates/create_condition?gateId=${GateId}&metric=critical_violations&op=GT&warning=5&error=10"', url: "http://3.16.33.107:9000/api/qualitygates/select?gateId=${GateId}&projectId=${ProjectId}"
}
	def call(){
def request = libraryResource 'sonarConnectorData.json'
createRepo(request)
}
