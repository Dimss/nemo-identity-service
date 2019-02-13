pipeline {
    agent any
    stages {
        stage("HelloWorld1"){
            steps {
                script {
                    openshift.withCluster(){
                        openshift.withProject(){
                            echo "Using project: ${openshift.project()}"
                            def saSelector = openshift.selector( 'serviceaccount' )
                           // Prints `oc describe serviceaccount` to Jenkins console
                            saSelector.describe()

                            // Selectors also allow you to easily iterate through all objects they currently select.
                            saSelector.withEach { // The closure body will be executed once for each selected object.
                                // The 'it' variable will be bound to a Selector which selects a single
                                // object which is the focus of the iteration.
                                echo "Service account: ${it.name()} is defined in ${openshift.project()}"
                            }
                        }
                    }
                }
            }
        }
    }
}