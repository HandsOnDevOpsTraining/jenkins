pipeline {
    agent any
    
    environment {
        DOCKER_REGISTRY = "hub.docker.com"
        DOCKER_REPO = "hello-ui"
        BUILD_NUMBER = "1.0.0"
        DOCKER_IMAGE = "handsondevops/${DOCKER_REPO}"
        DOCKER_USERNAME = "handsondevops"
        // DOCKER_PASSWORD = credentials('dockerhub-password')
    }
    
    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/docker-sample-ui-app.git'
            }
        }
        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .'
            }
        }
        
        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-password', variable: 'dockerhubpassword')]) {
                    sh "docker login -u handsondevops -p ${dockerhubpassword}"
                    sh "docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }
    }
}pipeline {
    agent any
    
    environment {
        DOCKER_REGISTRY = "hub.docker.com"
        DOCKER_REPO = "hello-ui"
        BUILD_NUMBER = "1.0.0"
        DOCKER_IMAGE = "handsondevops/${DOCKER_REPO}"
        DOCKER_USERNAME = "handsondevops"
        // DOCKER_PASSWORD = credentials('dockerhub-password')
    }
    
    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/docker-sample-ui-app.git'
            }
        }
        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .'
            }
        }
        
        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-password', variable: 'dockerhubpassword')]) {
                    sh "docker login -u handsondevops -p ${dockerhubpassword}"
                    sh "docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }
    }
}pipeline {
    agent any
    
    environment {
        DOCKER_REGISTRY = "hub.docker.com"
        DOCKER_REPO = "hello-ui"
        BUILD_NUMBER = "1.0.0"
        DOCKER_IMAGE = "handsondevops/${DOCKER_REPO}"
        DOCKER_USERNAME = "handsondevops"
        // DOCKER_PASSWORD = credentials('dockerhub-password')
    }
    
    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/docker-sample-ui-app.git'
            }
        }
        
        stage('Build Docker image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .'
            }
        }
        
        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-password', variable: 'dockerhubpassword')]) {
                    sh "docker login -u handsondevops -p ${dockerhubpassword}"
                    sh "docker push ${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }
    }
}