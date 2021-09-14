# Servlet
servlet 기반 웹 프로젝트

<h3> 1. HelloServlet : servlet으로 요청/응답하기.</h3>
   
    -   개발자 대신 서블릿이 HTTP요청메세지를 편리하게 사용할 수 있도록 
    HttlServletRequest 객체에 담아서 제공한다.

<h3> 2. HTTP 스팩과 , <br/>
    HTTP 요청또는 응답 메세지에-담긴-여러유형의-데이터를-서블릿으로-처리(파싱(?))하기 <br/>

    2-1. 이게 HTTP 메세지 스팩( 구조 및 구성) 이고,
            - start Line
                - HTTP 메소드
                - URL
                - 쿼리 스트링
                - 스키마 프로토콜
            - 헤더
                - 헤더 조회
            - 바디
                - form 파라미터 형식 조회
                - message body 데이터 직접 조회.

    2-2. 서버에서 (서블릿이 제공한) HTTPServletRequest객체로 HTTP요청메세지를 파싱해보
        ㄴ 2-1-1. HTTP '요청' 데이터 유형별 구현방법.
            ㄴ 요청 유형1. GET URL -> 파라미터(단일,복수, 같은이름의 여러값) 조회.
            ㄴ 요청 유형2. 두 클라이언트(웹브라우저,postman)에서 post Form형태의 http메세지 안의 파라미터 조회 및 원리

               원리1. [테스트] 결국 http메세지이기 때문에, 다양한 클라이언트에서 요청가능하다.
		        ㄴ 웹브라우저 > form( 웹브라저 form용 contentType을 자동 샛팅 > 쿼리스트링으로 자동 파싱 ) > http 메세지
		        ㄴ 포스트맨 > contentType 체크박스 설정 >. http 메세지 


               원리2. [Http] body에 담기는 데이터는 contentType 정의는 필수이다.

               원리3. [form] form용 contentType은 사전에 정의되어있으며, application/x-www-form-url-lencoded GET과 같은 형식으로 요청한다.

               원리4. [파라미터] application/x-www-form-url-lencoded은 파라미터를 “쿼리스트링파라미터로 자동 파싱”해준다. 이는 GET의 쿼리스트링파라미터와 같은 형식이다.

	           원리5. [조회] 그렇기때문에 “서버”는 GET/POST 모두 request.Paramerter 하나로 처리(조회)할 수 있다.

              
                
            ㄴ 요청 유형3. API 바디 > 단순 텍스트
            ㄴ 요청 유형4. API 바디 > JSON

    ㄴ 2-3. 서버에서 (서블릿이 제공한) HTTPServletResponse객체로 HTTP요청메세지를 파싱해보
        ㄴ 2-3-1. HTTP의 '응답' 데이터 유형별 구현방법. 
            ㄴ 응답 유형1. API 메세지 BODY (단순 텍스트, HTML)
            ㄴ 응답 유형2. API 메세지 BODY (JSON)

        
        