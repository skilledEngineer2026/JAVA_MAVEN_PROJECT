
pipeline {
    agent any

    environment {
        APP_NAME = 'java-maven-app'
        TARGET_ENV = 'dev'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Application: ${env.APP_NAME}"
                echo "Environment: ${env.TARGET_ENV}"
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                                 fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build successful!'
        }

        failure {
            echo 'Build failed!'
        }

        always {
            echo 'Pipeline finished.'
        }
    }
}
