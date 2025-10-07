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
          set -e
          java -version
          google-chrome --version || true
          mvn -v

          # Clean up any leftovers
          pkill -f chrome || true
          pkill -f chromedriver || true
          rm -rf /var/jenkins_home/.config/google-chrome || true
          rm -rf /var/jenkins_home/.cache/google-chrome || true

          # Fresh profile paths for this build
          export XDG_CONFIG_HOME="$(mktemp -d)"
          export XDG_CACHE_HOME="$(mktemp -d)"
          export CHROME_BIN="$(command -v google-chrome)"

          # Run tests under virtual display, keep Jenkins Maven tool PATH intact
          xvfb-run -a mvn -B clean test
        '''
      }
    }
  }
}
