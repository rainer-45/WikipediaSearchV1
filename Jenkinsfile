pipeline {
  agent any
  tools {
    jdk 'JDK 24'
    maven 'Maven 3.9.9'
  }
  options { timestamps() }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build and Test (Java 24)') {
      steps {
        sh '''
          echo "Using Java 24 and Maven"
          java -version
          mvn -v
          mvn -B clean test
        '''
      }
    }
  }
  post {
    always {
      junit '**/target/surefire-reports/*.xml'
      archiveArtifacts artifacts: '**/target/**/*', onlyIfSuccessful: false
    }
  }
}
