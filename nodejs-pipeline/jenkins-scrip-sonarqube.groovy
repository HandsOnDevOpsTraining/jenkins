pipeline {
    agent any

    environment {
        // GITHUB_TOKEN = credentials('github-token')
        SONAR_TOKEN = credentials('nodejs-secret')
    }

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/SonarQubeNodeJS.git'
            }
        }

        stage('Build with NPM') {
            steps {
                sh '''
                    npm install
                    npm run build --if-present
                    npm run test
                    npm run test:e2e
                '''
            }
        }

        
    }
}
