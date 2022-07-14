def call(Map config){
    script{
        def aws_profile="packer-role"
        if(config.aws_profile){
            aws_profile="env2"
        }
        if(config.branch){
            echo "Branch : ${config.branch}"
        }
        echo "Triggering Testcase Execution"
        echo "test_markers : ${config.test_markers}"
        echo "stages : ${config.stages}"
        echo "JOB_NAME : ${JOB_NAME}"
        echo "Build # : ${BUILD_NUMBER}"
        def usecase_validation = build job: 't3'
        env.jobResult = usecase_validation.getResult()
        env.racetrack_id = usecase_validation.getBuildVariables()
//         echo "${aws_profile}"
        sh '''
        echo "${aws_profile}"
         '''
        assert env.jobResult == "SUCCESS"
        return env.jobResult
    }
//      file_status=sh(script: 'curl -s -o /dev/null -w "%{http_code}" -u "${svc_user}:${svc_passwd}" https://jenkins-butler.svc.eng.vmware.com/job/"${JOB_NAME}"/"${BUILD_NUMBER}"/artifact/output/nimbus_sddc_details.json',returnStdout: true).trim()
//      if ("${file_status}" == '200') {
//         sh "wget --auth-no-challenge --http-user=${svc_user} --http-password=${svc_passwd} https://jenkins-butler.svc.eng.vmware.com/job/${JOB_NAME}/${BUILD_NUMBER}/artifact/output/nimbus_sddc_details.json"
//         env.org_id = sh(script: 'cat nimbus_sddc_details.json | jq ".org_id"| sed -e \'s/"//g\'',returnStdout: true).trim()
//         env.sddc_id = sh(script: 'cat nimbus_sddc_details.json | jq ".sddc_id"| sed -e \'s/"//g\'',returnStdout: true).trim()
//         echo "${org_id} ${sddc_id}"
//         def usecase_validation = build job: 'DIMENSION_TESTBED_VALIDATION',
//         parameters:[
//             string(name: 'test_markers', value: config.test_markers),
//             string(name: 'testbed_env', value: "Nimbus"),
//             string(name: 'deployment_env', value: "DEV"),
//             string(name: 'sddc_version', value: config.branch),
//             string(name: 'stages', value: config.stages),
//             string(name: 'org_id', value: "$org_id"),
//             string(name: 'sddc_id', value: "$sddc_id"),
//             string(name: 'testbed_info', value: "https://jenkins-butler.svc.eng.vmware.com/job/${JOB_NAME}/${BUILD_NUMBER}/artifact/fractal_nimbus_dev_hub_info.json"),
//             string(name: 'Build_user', value: 'Default_user')], propagate: false, wait:true
//             env.jobResult = usecase_validation.getResult()
//             env.racetrack_id = usecase_validation.getBuildVariables()["merged_racetrack_id"]
//             assert env.jobResult == "SUCCESS"
//             return env.racetrack_id
//      }
}
