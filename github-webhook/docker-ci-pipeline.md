# Integrate SonarQube with Jenkins 

## 🧰 Prerequisites
1. A Jenkins server 
2. Github account


## Integration Steps 


### On Github
1. Goto to the project where you want to enable automatic Jenkins build to enabled
   - Navigate to Settings -> Webhooks -> Add Webhook
   - Add the url of Jenkins with a suffix of "http://IP-ADDRESS-OF-JENKINS:8080/github-webhook/"

### On Jenkins server 

1. Enable Github Plugin
   - Navigate to Jenkins-> Manage Jenkins -> Plugin Manager -> Github Integration Plugin
   - Restart Jenkins after enabling the plugin
2. In the pipeline, enable "GitHub hook trigger for GITScm polling"

   
## 🧹 CleanUp  

   Stop Jenkins service and delete the instance 

   
## 🔗 My Profile
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/madan-lanka-0368a9b)
