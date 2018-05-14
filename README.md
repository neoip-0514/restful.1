# restful.1

- 이 문서는 SPRING INITIALIZR 로 생성 됨.
https://start.spring.io/

## github 저장소

https://github.com/neoip-0514/restful.1

## docker redis 실행

- 컨테이서 생성 후 시작
docker run --name redis -d -p 6379:6379 redis

- 중지된 컨테이너 시작
docker start redis

## 테스트

- GET - 키 전체조회
curl -X GET http://localhost:8080/restful.1/redis/event:20180514:apply

- POST - 키에 값 등록
curl -X POST http://localhost:8080/restful.1/redis/event:20180514:apply -H "Content-Type: application/json" -d '{"value": "값1"}'
