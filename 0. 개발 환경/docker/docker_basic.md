---
marp: true
---
# Docker 기본명령어 
## 참고문서 
- https://cultivo-hy.github.io/docker/image/usage/2019/03/14/Docker%EC%A0%95%EB%A6%AC/
- https://pyrasis.com/Docker/Docker-HOWTO

---
## 자주 사용하는 명령어 옵션들 
![Alt text](./img/basic/image11.png)

---
## Docker Desktop 실행(열기) 
![Alt text](./img/basic/image-1.png)

---
## search
- `docker search <이미지명>`: [Docker Hub](https://hub.docker.com/)에서 해당 이미지들을 검색할 수 있습니다.
![Alt text](./img/basic/image-2.png)

---
## pull
- `docker pull <이미지명>:<태그>`: 이미지를 받아올 수 있습니다.
![Alt text](./img/basic/image-4.png)

---
## images
- `docker images`: 다운로드 받은 이미지의 목록을 출력할 수 있습니다.

![Alt text](./img/basic/image-5.png)
![Alt text](./img/basic/image-11.png)

---
## [run](https://wooono.tistory.com/348)
- `docker run -i -t --name <컨테이너이름> ubuntu /bin/bash`
  - `-i`: 보통 이 옵션을 사용하여 Bash 에 명령을 입력합니다.
  - `-t`: Bash를 사용하려면 이 옵션을 설정해야 합니다.
  - `--name`: 컨테이너 이름을 설정합니다.

![Alt text](./img/basic/image-13.png)

---
## ps
- `docker ps -a`: 모든 컨테이너 목록을 출력합니다.
  -  `-a`: 사용이 정지된 컨테이너까지 모두 출력 

![Alt text](./img/basic/image-8.png)

---
## stop
- `docker stop <컨테이너 이름>`: 컨테이너 멈추기 

![Alt text](./img/basic/image-12.png)

---
## start
- `docker start <컨테이너 이름>`: 컨테이너 실행하기 

![Alt text](./img/basic/image-14.png)

---
## restart
- `docker restart <컨테이너 이름>`: 컨테이너 재실행하기 

![Alt text](./img/basic/image-16.png)


---
## attach
- `docker attach hello`: 컨테이너에 접속하기 

![Alt text](./img/basic/image-20.png)

---
## exec 
- `docker exec <컨테이너이름> echo "hello World"`: 외부에서 컨테이너에 명령하기 

![Alt text](./img/basic/image-17.png)

---
## rm
- `docker rm <컨테이너이름>`: 컨테이너 삭제  

![Alt text](./img/basic/image-18.png)

---
## rmi
- `docker rmi <이미지명>:<태그>`: 이미지 삭제 

![Alt text](./img/basic/image-19.png)


