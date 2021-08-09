pipeline {
    agent { label 'agent1' }
    parameters {
        booleanParam(name: 'DEBUG_BUILD', defaultValue: false,
        description: 'Is it the debug build?')
    }
    stages {
        
        stage("Checkout") {
            steps {
                git url: 'https://github.com/anish9849/calculator.git'
            }
        }
        
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
       
        stage('Test') {
            steps {
                sh "./gradlew --info test"
            }
        }
   
        stage('Coverage Coverage Test') {
            steps {
                sh "./gradlew jacocoTestCoverageVerification"
                sh "./gradlew jacocoTestReport"
            }
        }
   
        stage('deploy') {
            steps {
                echo "Hello Deploy!"
            }
        }
        
        stage('Example') {
            environment { NAME = 'ANISH' }
            when { expression { return params.DEBUG_BUILD } }
                steps {
                    echo "Hello from $NAME"
                    script {
                    def browsers = ['chrome', 'firefox']
                    for (int i = 0; i < browsers.size(); ++i) {
                    echo "Testing the ${browsers[i]} browser."
                    }
                }
            }
        }
    }
    post { always { echo 'I will always say Hello again!' } }
}
