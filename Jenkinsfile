pipeline {
    agent any
    stages {
        stage("HelloWorld1") {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject() {
                            def ciTemplate = readFile('ocp/ci/ci-template.yaml')
                            echo "${ciTemplate}"
                        }
                    }
                }
            }
        }
    }
}