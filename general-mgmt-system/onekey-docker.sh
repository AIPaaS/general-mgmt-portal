git pull
gradle clean && gradle build -x test
docker build -t 10.19.13.18:5000/general-mgmt-portal:v1.0 .   
docker push 10.19.13.18:5000/general-mgmt-portal:v1.0
