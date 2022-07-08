def add(x,y){
  echo "Sum of ${x} and ${y} : ${x+y}"
}

def sub(x,y){
  echo "Diff of ${x} and ${y} : ${x-y}"
}

def div(x,y){
  catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
    echo "${x}/${y}"
//         script{
//           sh (script:'${x}/${y}')
//         }
    archiveArtifacts artifacts: 'racetrack_link.txt'
  }
}
