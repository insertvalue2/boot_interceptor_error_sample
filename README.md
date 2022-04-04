# boot_interceptor_error_sample

정상 요청 모습 

<img width="768" alt="Screenshot_124" src="https://user-images.githubusercontent.com/18642092/161579826-d3826be0-590e-4a91-ba75-53a7c6fbf347.png">


예외가 발생 되어야 하는 모습 

http://localhost:8080/api/private/hello?name=mark1

<img width="781" alt="Screenshot_126" src="https://user-images.githubusercontent.com/18642092/161580233-3c97bae1-9afd-420a-92fe-3cec650230bd.png">


:: 다시 하니깐 정상 작동 하네 ㅋㅋㅋ
http://localhost:8080/api/private/hello?name=mark



:: 401 이 나오면 정상 동작 

http://localhost:8080/api/private/hello?name=mark1
