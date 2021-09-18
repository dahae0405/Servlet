# Servlet
servlet 기반 웹 프로젝트

<h3> 1. HelloServlet : servlet으로 요청/응답하기.</h3>
   
    -   개발자 대신 서블릿이 HTTP요청메세지를 편리하게 사용할 수 있도록 
    HttlServletRequest 객체에 담아서 제공한다.

<h3> 2. HTTPServlet </h3>
   - HTTP 스팩과 , <br/>
      HTTP메세지로 요청/응답이 올경우, 쿼리파라미터,Form,단순텍스트,json을 파싱하여 요청조회, 응답생성해보자


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

    2-2. 파싱 순서
        
    2-3. 실습
    ㄴ 1) HTTP 요청데이터 <=> 개발자는 서버에서 서블릿이 생성한 HTTPServletRequest객체를 사용.
        ㄴ 2-1-1. HTTP '요청' 데이터 유형별 조회 구현방법.
            ㄴ 요청 유형1. API start Line > GET 쿼리 파라미터 : getParamName
            ㄴ 요청 유형2. API 바디 > POST HTML FORM : (application/text)타입으로 1번과 동일 조회.
            ㄴ 요청 유형3. API 바디 > 단순 텍스트 : 바이트로 stream 조회
            ㄴ 요청 유형4. API 바디 > JSON : json도 문자이기 때문에 stream 조회.
            
            
            정리 
               [[ 형태(데이터 타입) 바꾸기 ]] 
               파싱1 : 수동 key명 명시 
                     ㄴ 예시. GET/Form : 동일 getParam 조회
                     
               파싱2 : 자동 key명 제공 ( 라이브러리 objectMapper ) 
                     ㄴ 예시. 바디 : 모든 메세지는 바이트로 stream으로 String 조회                     
                        ㄴ ( 바이트 <> 문자(String) <> 자바객체(Object) ) 
                        ㄴ ( 바이트 <> json(json)  <> 자바객체(Object ) ) 
                     

    ㄴ 2) HTTP 응답데이터 <= > 개발자는 서버에서 서블릿이 생성한 HTTPServletResponse객체를 사용.
        ㄴ 2-3-1. HTTP의 '응답' 데이터 유형별 응답 생성 구현방법. 
            ㄴ 응답 유형1. API 메세지 BODY (단순 텍스트, HTML)
            ㄴ 응답 유형2. API 메세지 BODY (JSON)
            
            정리
               [[ 값 샛팅하기 ]] 
               set/get 호출과 샛팅 : 
                  ㄴ 수동 호출
                  ㄴ response set/get 호출

        
<h3> 3. AdvanceServlet </h3>
      - servlet으로 member 저장/조회/테스트 
