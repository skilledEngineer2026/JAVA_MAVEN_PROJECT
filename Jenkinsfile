
pipeline {
    agent any

    environment {
        APP_NAME = 'java-maven-app'
        TARGET_ENV = 'dev'
        DEMO_SECRET = credentials('demo-secret')
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

        
        stage('Check Credential') {
            steps {
                bat 'if defined DEMO_SECRET (echo Secret is configured) else (echo Secret is missing)'
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
