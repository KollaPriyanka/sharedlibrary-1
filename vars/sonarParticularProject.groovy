import groovy.json.JsonSlurper 

@NonCPS
detailplan(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def colkey= resultJson.colkey
def credentials = resultJson.cname
httpRequest authentication: "${credentials}", contentType: "APPLICATION_JSON", 
    
    httpMode: 'GET', url: "http://3.16.33.107:9000/api/measures/component?metricKeys=ncloc,complexity,violations&component=${colkey}"
}
	def call(){
def request = libraryResource 'sonarConnectorData.json'
detailplan(request)
}
