pipeline {
    agent {
        node {
            label 'maven'
        }
    }
    stages {
        stage("HelloWorld1") {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject() {
                            def ciTemplate = readFile('ocp/ci/ci-template.yaml')
                            def scmUrl = scm.getUserRemoteConfigs()[0].getUrl()
                            def currentOcpProject = openshift.project()
                            def models = openshift.process(ciTemplate,
                                    "-p=PROJECT_NAME=${currentOcpProject}",
                                    "-p", "GIT_REPO_URL=${scmUrl}")
                            echo "${models.size()}"
                            for (o in models) {
//                                echo "${o}"
//                                echo "${o.metadata}"
//                                echo "${o.metadata.name}"
//                                echo "${o.kind}"
                                if (o.kind == "ImageStream" & o.metadata.name == "postgres"){
                                    echo "${o}"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}