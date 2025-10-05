pipeline {
  agent any
  tools {
    jdk 'JDK 24'        // you already added this in Tools with /opt/jdk/jdk24
    maven 'Maven 3.9.9'
  }
  options { timestamps() }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build and Test, headless Chrome') {
      steps {
        sh '''
          java -version
          google-chrome --version || true
          mvn -v
          # Run tests under a virtual display, no code changes needed
          xvfb-run -a mvn -B clean test
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
