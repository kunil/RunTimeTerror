pipeline {

  stages {   
    stage('Checkout') {
        steps {
            git url: 'https://github.com/kunil/RunTimeTerror.git',
                branch: 'main'
        }
    }
    stage('Test') {
      steps {
        sh "mvn clean test"
      }
    }
    stage('Build') {
      steps {
        sh "mvn -DskipTests=true clean package"
      }
    }
    stage('Deploy') {
      steps {
        sh "echo 'Deploying'"
      }
    }
  }
}