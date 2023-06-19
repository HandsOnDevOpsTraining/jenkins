# Integrate SonarQube with Jenkins 

## 🧰 Prerequisites
1. a SonarQube Server [Click here to Setup Sonarqube server](https://github.com/HandsOnDevOpsTraining/docker-and-sonarqube-installation-in-aws)
2. A Jenkins server 


Integration Steps 

### On SonarQube server 

1. Generate a SonarQube token to authenticate from Jenkins

### On Jenkins server 

1. Install SonarQube Scanner for Jenkins plugin
2. Create credentails that will be used in step 3 below
   - Goto Dashboard -> Manage Jenkins -> "Manage Credentials"
3. Configure SonarQube credentials 
   - Add SonarQube Server in 
   -- Goto Dashboard -> Manage Jenkins -> "Configure System" 
4. Run Pipeline job 
   - Use help of chatgpt to create a pipeline script
   - E.g. create a jenkins pipeline script for cloning code from github, building java code using maven and run sonar qube using mvn sonar using project key, name and secret


## 🧹 CleanUp  

   Stop SonarQube services and delete the instance
   Stop Jenkins service and delete the instance 

   
## 🔗 My Profile
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/madan-lanka-0368a9b)
