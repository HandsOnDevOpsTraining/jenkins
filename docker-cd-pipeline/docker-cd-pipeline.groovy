pipeline {
    agent any
    
    environment{
        DOCKER_PASSWORD = credentials('dockerhubpwd')
    }
    
    stages {
        stage ('clone the repository') {
            steps{
               git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/docker-sample-ui-app.git'
            }
        }
        
        stage ('build a docker image'){
            steps{
                sh 'docker build -t handsondevops/sample-ui-app-29-june .'
                sh 'docker images -a'
            }
        }
        
        stage ('publish to docker hub'){
            steps{
                sh "docker login -u handsondevops -p ${DOCKER_PASSWORD}"
                sh "docker push handsondevops/sample-ui-app-29-june"
            }
        }
        
        stage ('Execute the application'){
            steps{
                sh "docker run -p 7000:80 handsondevops/sample-ui-app-29-june &"
            }
        }
    }
}