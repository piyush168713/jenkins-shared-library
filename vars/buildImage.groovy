#!/usr/bin/env groovy

// def call(){
//     echo "building the docker image..."
//     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh 'docker build -t piyush168713/demo-app:jma-2.6 .'
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh 'docker push piyush168713/demo-app:jma-2.6'
//     }
// }

// use double quotes("") if any variable exists in statement


def call(String imageName){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
}

