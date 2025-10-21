pipeline {
  agent any
  tools {
    jdk 'JDK 24'          // Manage Jenkins -> Tools -> JDK 24 -> /opt/jdk/jdk24
    maven 'Maven 3.9.9'   // Name must match your Maven tool exactly 1234
  }
  options { timestamps() }
  stages {
    stage('Checkout') { steps { checkout scm } }

    stage('Build and Test, headless Chrome') {
      steps {
        powershell '''
          $ErrorActionPreference = "Stop"
          mvn -v
          mvn -B -ntp clean test
        '''
      }
    }
  }
}
