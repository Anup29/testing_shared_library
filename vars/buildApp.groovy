def call(){
  sh "echo build function..."
echo "Build number is ${currentBuild.number}"
}

