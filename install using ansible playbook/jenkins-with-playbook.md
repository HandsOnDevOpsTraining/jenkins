## Jenkins installation procedure using Ansible Playbook
To install Jenkins on Ubuntu using Ansible playbook and set it to start automatically during bootup, you can follow these steps:

## 🧰 Prerequisites
Step 1: Install Ansible
Make sure you have Ansible installed on your system. If not, you can install it using the following command:

```
sudo apt update
sudo apt install ansible
```

Step 2: Create the Ansible playbook
Create a new file named `jenkins_install_playbook.yml` with the following content:

```yaml
---
- hosts: all
  become: true
  tasks:
    - name: Install Java
      apt:
        name: openjdk-11-jdk
        state: present

    - name: Add Jenkins APT key
      apt_key:
        url: https://pkg.jenkins.io/debian/jenkins.io.key
        state: present

    - name: Add Jenkins repository
      apt_repository:
        repo: deb https://pkg.jenkins.io/debian-stable binary/
        state: present

    - name: Update apt cache
      apt:
        update_cache: yes

    - name: Install Jenkins
      apt:
        name: jenkins
        state: present

    - name: Start Jenkins service
      service:
        name: jenkins
        state: started
        enabled: yes
```

Step 3: Run the Ansible playbook
Save the playbook and execute it using the following command:

```
ansible-playbook -i localhost, -c local jenkins_install_playbook.yml
```

This will install Jenkins on your Ubuntu machine.

Step 4: Access Jenkins
Once the installation is complete, you can access Jenkins through your web browser by navigating to `http://localhost:8080` or `http://your-server-ip:8080`.

Step 5: Initial Jenkins setup
During the first access, Jenkins will ask for an initial admin password. You can retrieve the password by running the following command:

```
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

Copy the password and paste it into the Jenkins setup wizard on your web browser.

Step 6: Enable Jenkins to start on boot
The playbook already sets Jenkins to start automatically on boot. So, you don't need to perform any additional steps for that.

With these steps, you should have Jenkins installed and running on your Ubuntu system, and it will start automatically during bootup.