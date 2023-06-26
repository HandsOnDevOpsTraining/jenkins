# Create Docker CI pipeline in Jenkins

## 🧰 Prerequisites
1. A Jenkins server 


## Integration Steps 

### On Jenkins server 

1. Configure hub.docker.com credentials 
   - Navigate to Jenkins-> Manage Jenkins -> Credentials -> System & Global (Domain) -> Add credentials -> Add a secret variable with name "dockerhub-password" & value as Docker Hub Password
2. Run Pipeline job 
   - Use help of chatgpt to create a pipeline script
   - E.g. create a Jenkins pipeline script to clone the code from github public repo and main branch, publish docker image sample-ui:1.0.0 to dockerhub using username handsondevops and with credentials from encrypted password 

## 🧹 CleanUp  

   Stop Jenkins service and delete the instance 

   
## 🔗 My Profile
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/madan-lanka-0368a9b)
