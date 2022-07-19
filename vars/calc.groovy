static def add(x,y){
  println("Sum of ${x} and ${y} : ${x+y}")
}

static def sub(x,y){
  println("Diff of ${x} and ${y} : ${x-y}")
  return "${x-y}"
}

def div(x,y){
  catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
        script{
          sh (script:'${x/y}')
        }
//     archiveArtifacts artifacts: 'racetrack_link.txt'
  }
}
