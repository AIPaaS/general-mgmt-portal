tagversion=v1.0
git reset --hard origin/master 
git pull 
chmod a+x onekey-docker.sh 
gradle clean && gradle build -x test 
docker build -t 10.19.13.18:5000/general-mgmt-portal:${tagversion} .   
docker push 10.19.13.18:5000/general-mgmt-portal:${tagversion} 

docker rmi aioptapp/general-mgmt-portal:${tagversion} 
docker tag 10.19.13.18:5000/general-mgmt-portal:${tagversion} aioptapp/general-mgmt-portal:${tagversion} 
docker login --username=aioptapp --password=aioptapp@123 --email=wuzhen3@asiainfo.com 
docker push aioptapp/general-mgmt-portal:${tagversion} 