pipeline{

  agent any

  tools
  {
            maven 'maven'
            jdk 'java'
  }

  stages
  {
    stage("Install")
    {
          steps
          {
            sh 'mvn clean install'
          }
    }
  }
}

