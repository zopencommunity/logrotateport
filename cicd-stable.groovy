node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/ZOSOpenTools/logrotateport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/ZOSOpenTools/logrotateport.git'), string(name: 'PORT_DESCRIPTION', value: 'The logrotate utility is designed to simplify the administration of log files on a system which generates a lot of log files.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
