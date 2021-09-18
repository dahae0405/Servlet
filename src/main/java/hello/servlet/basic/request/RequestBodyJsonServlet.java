package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.Lombock;
import lombok.Lombok;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *  과제
 *      Stream 사용하여  Http body json API를 조회
 *  입력
 *      Post    http://localhost:8080//request-body-json?
 *      row     json
 *                  {"username":"gwon","age":20}
 *  결과
 *      1. 문자로 출력하기
 *          걀과 : messageBody = {"username":"gwon","age":20}     // 결국, json도 문자임. 그래서 inputStream으로 데이터 읽을 수 있다. 형태를 갖고있어 json형태라고 많이 불림.
 *
 *      2. 자바 객체로 파싱하여 출력하기
 *          결과 : lombokData = hello.servlet.Lombock@72adec50    // Spring에서 제공하는 json 파싱 도구로 출력하기 ( jackson 라이브러리를 제공, gson 등등, ... )
 *
 *      3. 1번 코드 제거하여 결과를 출력해보기
 *          처리 : service(HttpServletRequest req, HttpServletResponse resp) => service(Lombok lombokData )
 *          결과 : 2번과 동일
 *          원리 : 파라미터를 롬복으로 자동 파싱 처리하여 inputStream 데이터 조회 코드를 제거 할 수 있다.
 *
**/

@WebServlet(name="requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString( inputStream,StandardCharsets.UTF_8 );
        System.out.println("messageBody = "+ messageBody);  // 1번 답


        Lombock lombokData = objectMapper.readValue(messageBody, Lombock.class);
        System.out.println("lombokData = "+ lombokData);                // 2번 답 lombokData = hello.servlet.Lombock@72adec50
        System.out.println("username = "+ lombokData.getUsername());    // 2번 답 username = "gwon"


        resp.getWriter().write("ok");
    }

}


