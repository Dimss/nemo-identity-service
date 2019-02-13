pipeline {
    agent any
    stages {
        stage("HelloWorld1"){
            steps {
                script {
                    openshift.withCluster(){
                        openshift.withProject(){
                            echo "Using project: ${openshift.project()}"
                        }
                    }
                }
            }
        }
    }
}