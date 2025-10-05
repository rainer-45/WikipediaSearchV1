pipeline {
  agent any
  tools {
    maven 'Maven 3.9.9'
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build and Test') {
      steps {
        sh 'mvn -B test'
      }
    }
  }
  post {
    always {
      // Publish the TestNG/Surefire results
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/**/*', onlyIfSuccessful: false
    }
  }
}
