pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/HandsOnDevOpsTraining/reactjs-ui-demo.git'
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
