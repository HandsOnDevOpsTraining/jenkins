pipeline {
    agent any
    
    environment{
        DOCKER_REPO = "sample-ui"
        BUILD_NUMBER = "1.0.0"
        DOCKER_IMAGE = "handsondevops/${DOCKER_REPO}"
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
                sh 'docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .'
                sh 'docker images -a'
            }
        }
        
        stage ('publish to docker hub'){
            steps{
                sh "docker login -u handsondevops -p ${DOCKER_PASSWORD}"
                sh "docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}"
            }
        }
        
        stage ('Execute the application'){
            steps{
                sh "kubectl apply -f kubernetes-my-sample-ui-deployment-LoadBalancer.yaml"
            }
        }
    }
}