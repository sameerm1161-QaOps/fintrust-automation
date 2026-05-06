pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/sameerm1161-QaOps/fintrust-automation.git'
            }
        }

        stage('Build Docker Image') {
            steps {
               bat 'docker build -t fintrust-automation .'
            }
        }

        stage('Run Automation Tests') {
            steps {
                 bat 'docker run -v %cd%\\allure-results:/app/allure-results fintrust-automation'
            }
        }

        stage('Generate Allure Report') {
            steps {
                  allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'allure-results/**'
        }

        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }
    }
}