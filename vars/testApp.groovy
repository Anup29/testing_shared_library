def call(){
  sh "echo test function..."
  echo "${name_of_job}"
  def usecase_validation = build job: 't2'
}
