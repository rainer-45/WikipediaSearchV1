pipeline {
  agent {
    docker {
      image 'maven:3.9.9-eclipse-temurin-24'
      args '-v $HOME/.m2:/root/.m2'
    }
  }
  options { timestamps() }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build and Test with JDK 24') {
      steps {
        sh 'java -version'
        sh 'mvn -v'
        sh 'mvn -B clean test'
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
