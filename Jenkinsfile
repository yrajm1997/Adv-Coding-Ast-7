pipeline {
  agent any
  stages {
    stage('Checking the file content') {
      steps {
        sh 'ls'
      }
    }

    stage('Package') {
      steps {
        sh 'mvn clean package'
      }
    }

  }
}