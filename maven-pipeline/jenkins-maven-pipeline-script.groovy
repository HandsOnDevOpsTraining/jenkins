pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/java-unit-tests-maven.git'
            }
        }
        
        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test with Maven') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
