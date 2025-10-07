pipeline {
  agent any
  tools {
    jdk 'JDK 24'          // Manage Jenkins -> Tools -> JDK 24 -> /opt/jdk/jdk24
    maven 'Maven 3.9.9'   // Name must match your Maven tool exactly
  }
  options { timestamps() }
  stages {
    stage('Checkout') { steps { checkout scm } }

    stage('Build and Test, headless Chrome') {
      steps {
        sh '''
          # Run tests under virtual display, keep Jenkins Maven tool PATH intact
          xvfb-run -a mvn -B clean test
        '''
      }
    }
  }
}
