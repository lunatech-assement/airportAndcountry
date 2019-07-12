node(label:'docker') {

    def img
	
    try {
        stage('Checkout') {         
            checkout scm
		}
			
	        docker.image('maven:3-alpine').inside('-v /root/.m2:/root/.m2') {
	
	        stage('Build') {
	
	        sh 'mvn -DskipTests install package'
	            }
	
            stage('Copy Jar to workspace') {
                
                sh 'cp ?/.m2/repository/com/lunatech/countriesandairport/countries-airport-service/0.0.1-SNAPSHOT/countries-airport-service-0.0.1-SNAPSHOT.jar ./countries-airport-service.jar'
            }
	        }
	        
	        
        stage('Build Docker image') {
        
        img = docker.build('shah1992/countries-airport:1.0.0')
        
 		}

		
		docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
		
			stage('Publish') {
				
			println('inside Publish stage')
			img.push()
			} 
			
		stage('Run Container on Dev Server'){
     	def dockerRun = 'sudo docker run -p 8082:8080 -d --name countryandairport shah1992/countries-airport-service:1.0.0'
    	sshagent(['aws-docker']) {
       	sh "ssh -o StrictHostKeyChecking=no ec2-user@172.31.33.110 ${dockerRun}"
     }
     
   }
        }
    }
		    catch(err) {
		        currentBuild.result = 'FAILED'
		        println(err.toString())
		        println(err.getMessage())
		    }
		    finally {
		        stage('Clean up') {
		            cleanWs()
		        }
		    }

}