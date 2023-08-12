pipeline {
    agent {
        label 'aws-ec2-node' // Replace 'aws-ec2-label' with the actual label of your AWS EC2 agents
    }

    environment {
        SONARQUBE_HOST = 'http://52.15.182.125:9000'
        SONARQUBE_TOKEN = credentials('sonarqube3')
    }

    stages {
        stage('Clone') {
            steps {
                // Clone the GitHub repository
                git branch:'main', url: 'https://github.com/HandsOnDevOpsTraining/java-unit-tests-maven.git'
            }
        }

        stage('Build with Maven') {
            steps {
                // Build Java code using Maven
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }

        stage('SonarQube analysis') {
            steps {
                // Run SonarQube analysis using Maven with project key and name
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=jenkins-maven -Dsonar.projectName=jenkins-maven -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.host.url=${SONARQUBE_HOST}'
                }
            }
        }
    }
}
