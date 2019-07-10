node(label:'docker') {

    def img
    def tag
    def name
    def current_tag

    try {
        stage('Checkout') {         
            checkout scm
			//get the current git tag
            current_tag = sh(returnStdout: true, script: 'git tag --sort=v:refname | tail -n 1').trim()
            sh 'chmod o+w -R .'
			sh 'echo Current tag value : ${current_tag}'
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
        
        img = docker.build('shah1992/countries-airport')
 		}

		
		docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
		
			stage("Publish") {
				
			println("inside Publish stage")
			img.push()
			} 
			
	stage('Run Container on Dev Server'){
     def dockerRun = 'docker run -p 8082:8080 -d --name airport shah1992/airport-assembly:1.0.3'
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