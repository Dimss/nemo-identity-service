pipeline {
//    agent any
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
                            def models = openshift.process(
                                    ciTemplate,
                                    "-p=PROJECT_NAME=postgres",
                                    "-p=GIT_REPO_URL=postgres")
//                                    "-p=POSTGRESQL_DATABASE=postgres",
//                                    "-p=POSTGRESQL_PASSWORD=postgres",
//                                    "-p=POSTGRESQL_USER=postgres",
//                                    "-p=DATABASE_SERVICE_NAME=pg")
                            echo "${models}"
//                            openshift.create(models)
//                            def scmUrl = scm.getUserRemoteConfigs()[0].getUrl()
//                            def currentOcpProject = openshift.project()
//                            def models = openshift.process(ciTemplate,
//                                    "-p=PROJECT_NAME=${currentOcpProject}",
//                                    "-p", "GIT_REPO_URL=${scmUrl}")
//                            openshift.delete(models)
//                            echo "${models.size()}"
//                            for (o in models) {
//                                echo "${o}"
//                                echo "${o.metadata}"
//                                echo "${o.metadata.name}"
//                                echo "${o.kind}"
//                                if (o.kind == "ImageStream" & o.metadata.name == "postgres"){
//                                    echo "${o}"
//                                }
//                            }

                            sh "mvn clean install -Dspring.profiles.active=prod"
                        }
                    }
                }
            }
        }
    }
}