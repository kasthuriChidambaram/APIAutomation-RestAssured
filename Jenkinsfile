pipeline {
    agent any

    tools {
        maven 'Maven'  // Maven tool name defined in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your GitHub repository
                git url: 'https://github.com/kasthuriChidambaram/APIAutomation-RestAssured.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Compile and build the project using Maven from the ProjectRestAssured directory
                dir('ProjectRestAssured') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Run Tests') {
            steps {
                // Run API tests with Cucumber and Rest Assured using Maven from the ProjectRestAssured directory
                dir('ProjectRestAssured') {
                    sh 'mvn test'
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish Cucumber report in Jenkins from the ProjectRestAssured directory
                cucumber buildStatus: 'FAILURE',
                          fileIncludePattern: '**/ProjectRestAssured/target/cucumber-reports/*.json',
                          sortingMethod: 'ALPHABETICAL'
            }
        }

        stage('Archive Test Results') {
            steps {
                // Archive test results for reference in Jenkins from the ProjectRestAssured directory
                archiveArtifacts artifacts: '**/ProjectRestAssured/target/cucumber-reports/*.json', allowEmptyArchive: true
                junit '**/ProjectRestAssured/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            // Clean up the workspace after the pipeline execution
            cleanWs()
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
