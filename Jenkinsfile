pipeline{

  agent any

  tools
  {
            maven 'maven'
            jdk 'java'
  }

  stages
  {
    stage("Build")
    {
          steps
          {
            sh 'mvn clean build -U'
          }
    }
  }
}

