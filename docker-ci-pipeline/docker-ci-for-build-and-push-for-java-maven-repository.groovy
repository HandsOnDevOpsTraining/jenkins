pipeline {
    agent any
    
    environment{
        dockerhubpwd = credentials('dockerhubpwd')
    }

    stages {
        stage('Clone or Checkout Code') {
            steps {
                git url:"https://github.com/HandsOnDevOpsTraining/java-unit-tests-maven.git", branch:"main"
            }
        }

        stage('Build Code') {
            steps {
                // Build the Java project using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test Code') {
            steps {
                // Run unit tests using Maven
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image for the Java application
                sh 'docker build -t handsondevops/jenkins-aug-2024-image:v1 .'
            }
        }
        
        stage('Push Docker Image') {
            steps {
                // Push Docker image to the Docker Hub
                // This is similar to the Service Connection step in Azure DevOps
                sh 'docker login -u handsondevops -p ${dockerhubpwd}'
                sh 'docker push handsondevops/jenkins-aug-2024-image:v1'
            }
        }
    }

    post {
        always {
            // Clean up any leftover Docker images or containers
            sh 'docker system prune -f'
        }

        success {
            echo 'Build and test completed successfully!'
        }

        failure {
            echo 'Build or test failed.'
        }
    }
}
