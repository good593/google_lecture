# server image는 ubunutu 18.04를 사용
FROM ubuntu:18.04 

# image가 올라갔을 때 수행되는 명령어들
# -y 옵션을 넣어서 무조건 설치가 가능하도록 한다.
RUN \
    apt-get update && \
    apt-get install -y apache2

# 파일 복사 
COPY hello.html /var/www/html

# 작업공간 이동 (=cd)
WORKDIR /var/www/html

# apache가 기본적으로 80포트를 사용하기 때문에 expose를 이용해 apache server로 접근이 가능하도록 한다.
EXPOSE 80 

# 컨테이너가 생성 된 이후에 내부의 아파치 서버는 항상 실행중인 상태로 만들어준다.
# apachectl을 foreground(즉, deamon)상태로 돌아가도록 한다.
CMD ["apachectl", "-D", "FOREGROUND"]

