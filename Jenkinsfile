node {
   def app
   def mvnHome
   
   stage('Clone repository') {
        checkout scm
        mvnHome = tool 'maven'
    }
   
   stage('Teste Pedido') {
         sh "'${mvnHome}/bin/mvn' test"
   }

    stage('Build image Pedido') {
        app = docker.build("tas4/pedido")
    }
    
    stage('Test image Pedido') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }
    
    stage('Push Pedido image') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
   }
}
