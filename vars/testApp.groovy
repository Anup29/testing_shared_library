def call(){
  sh "echo test function..."
  echo "${name_of_job}"
  def usecase_validation = build job: 't2'
  env.jobResult = usecase_validation.getResult()
  echo "${env.jobResult}"
  env.racetrack_id = usecase_validation.getBuildVariables()
  echo "${env.racetrack_id}"
}
