pipeline {
    agent any
    stages {
        stage("HelloWorld1"){
            steps {
                script {
                    openshfit.withCluster(){
                        openshfit.withProject(){
                            echo "Using project: ${openshfit.project()}"
                        }
                    }
                }
            }
        }
    }
}