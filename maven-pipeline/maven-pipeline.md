# Integrate SonarQube with Jenkins 

## 🧰 Prerequisites
1. a SonarQube Server [Click here to Setup Sonarqube server](https://github.com/HandsOnDevOpsTraining/docker-and-sonarqube-installation-in-aws)
2. A Jenkins server 


Integration Steps 

### On SonarQube server 

1. Generate a SonarQube token to authenticate from Jenkins

### On Jenkins server 

1. Install SonarQube plugin
2. Configure SonarQube credentials 
3. Add SonarQube to jenkins "configure system" 
4. Install Maven 
   - apt-get install maven
5. Run Pipeline job 
   - Use help of chatgpt to create a pipeline script
   - E.g. create a jenkins pipeline script for cloning code from github and building java code using maven 

## 🧹 CleanUp  

   Stop SonarQube services and delete the instance
   Stop Jenkins service and delete the instance 

   
## 🔗 My Profile
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/madan-lanka-0368a9b)
