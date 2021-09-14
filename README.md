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
            ㄴ 요청 유형1. API start Line > GET 쿼리 파라미터
            ㄴ 요청 유형2. API 바디 > POST HTML FORM
            ㄴ 요청 유형3. API 바디 > 단순 텍스트
            ㄴ 요청 유형4. API 바디 > JSON

    ㄴ 2-3. 서버에서 (서블릿이 제공한) HTTPServletResponse객체로 HTTP요청메세지를 파싱해보
        ㄴ 2-3-1. HTTP의 '응답' 데이터 유형별 구현방법. 
            ㄴ 응답 유형1. API 메세지 BODY (단순 텍스트, HTML)
            ㄴ 응답 유형2. API 메세지 BODY (JSON)

        
        