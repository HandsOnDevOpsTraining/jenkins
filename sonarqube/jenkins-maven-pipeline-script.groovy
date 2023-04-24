pipeline {
    agent any

    environment {
        // GITHUB_TOKEN = credentials('github-token')
        SONAR_TOKEN = credentials('sonarqube-secret')
        SONARQUBE_HOST = 'http://3.17.140.54:9000'
        SONARQUBE_LOGIN = credentials('sonarqube-secret')
    }

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/java-unit-tests-maven.git'
            }
        }
        
        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
                sh 'mvn test'
            }
        }

        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.host.url=$SONARQUBE_HOST -Dsonar.token=$SONARQUBE_LOGIN -Dsonar.projectName=maven-jenkins -Dsonar.projectKey=maven-jenkins'
                }
            }
        }
    }
}
