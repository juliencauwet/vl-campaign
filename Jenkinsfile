pipeline {
    agent any
    tools{
        maven 'Maven 3.6.0'
    }
    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/juliencauwet/vl-campaign.git'
            }
        }

        stage('Build'){
            steps {
                    sh 'mvn clean install -DskipTests'
            }

        }


        stage('Deploy'){
            steps {
                sh '''
                    docker-compose down
                    docker-compose up -d
                    docker ps -a
                '''
            }
        }

    }

}
