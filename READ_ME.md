### Docker File (Dockerfile)

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]

### Docker commands to run application on docker(wsl):

* Connect WSL (Linux Machine):
    #### wsl
* Open to project(name: docker) location:
    #### cd /mnt/c/POC-SpringBoot/Docker_POC/docker/
* Build (Name of build on docker -> mydockerapp):
    ####  docker build -f Dockerfile -t mydockerapp .
  * Docker Result *****
  
    Sending build context to Docker daemon  20.44MB
      Step 1/4 : FROM openjdk:8-jdk-alpine
      ---> a3562aa0b991
      Step 2/4 : ARG JAR_FILE=target/*.jar
      ---> Using cache
      ---> 4c12f0083610
      Step 3/4 : COPY ${JAR_FILE} app.jar
      ---> Using cache
      ---> 9ab1278d8bad
      Step 4/4 : ENTRYPOINT ["java","-jar", "/app.jar"]
      ---> Using cache
      ---> f05b632e40f2
      Successfully built f05b632e40f2
      Successfully tagged mydockerapp:latest
  

* Run the application:
    #### docker run -p 9900:8080 mydockerapp

* Remove Container:  docker container prune
* List Container  :  docker container ls
* List Image      :  docker image ls
* Remove Container:  docker container rm containerId
* Remove Image    :  docker image rm imageId

## Docker Hub: https://hub.docker.com/repositories