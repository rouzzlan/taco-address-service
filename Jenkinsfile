pipeline {
    agent any
    tools {
        jdk 'graalvm-ee-java17-22.3.1'
    }
    environment {
        DOCKER_TAG = 'harbour.739.net/taco-cloud/address-service:0.0.2'
    }
    stages {
        stage('Setup') {
            steps {
                sh '''
                    ./gradlew clean buildDependents
                '''
            }
        }
        stage('Build Docker') {
            when {
            expression {
                env.BRANCH_NAME == 'master'
              }
            }
            steps {
                sh '''
                    ./gradlew build -Dquarkus.package.type=native
                    docker build -f src/main/docker/Dockerfile.native -t ${DOCKER_TAG} .
                    docker login harbour.739.net -u="rouslan" -p="50m9FiD3"
                    docker push ${DOCKER_TAG}
                '''
            }
        }
    }
}