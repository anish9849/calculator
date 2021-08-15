pipeline {
    agent { label 'agent1' }
    pollSCM('* * * * *')
    parameters {
        booleanParam(name: 'GENERATE_REPORT', defaultValue: false,
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
        
        stage('Coverage Test') {
            when { expression { return params.GENERATE_REPORT } }
            steps {
                sh "./gradlew test jacocoTestCoverageVerification"
                sh "./gradlew test jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html/',
                    reportFiles: 'index.html',
                    reportName: "JaCoCo Report"
                ])
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: "Checkstyle Report"
                ])
            }
        }
        
        // stage('Example') {
        //     environment { NAME = 'ANISH' }
        //     when { expression { return params.DEBUG_BUILD } }
        //         steps {
        //             echo "Hello from $NAME"
        //             script {
        //             def browsers = ['chrome', 'firefox']
        //             for (int i = 0; i < browsers.size(); ++i) {
        //             echo "Testing the ${browsers[i]} browser."
        //             }
        //         }
        //     }
        // }
    }
    post { always { echo 'I will always say Hello again!' } }
}
