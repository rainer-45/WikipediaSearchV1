pipeline {
  agent any
  tools {
    jdk 'JDK 24'
    maven 'Maven 3.9.9'
  }
  options { timestamps() }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build and Test, headless Chrome') {
      steps {
        sh '''
          set -e
          java -version
          google-chrome --version || true
          mvn -v

          # Kill any leftover Chrome or chromedriver from prior runs
          pkill -f chrome || true
          pkill -f chromedriver || true

          # Remove any stale default Chrome profile
          rm -rf /var/jenkins_home/.config/google-chrome || true
          rm -rf /var/jenkins_home/.cache/google-chrome || true

          # Create a unique, clean profile per build
          export XDG_CONFIG_HOME="$(mktemp -d)"
          export XDG_CACHE_HOME="$(mktemp -d)"
          export CHROME_BIN="$(command -v google-chrome)"

          # Run tests under a virtual display
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
