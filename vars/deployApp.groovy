def call(){
  sh "echo deploy function..."
echo "${params.token}"
  echo "${job_build_id}"

  
}
