package hello.servlet.basic.request;

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
 *      Stream 사용하여  Http body text API를 조회
 *  입력
 *      Post http://localhost:8080/RequestBodyJsonServlet?
 *      body
 *          hello
 *  츌력
 *      hello
 *
 *  원리
 *      inputStream으로 데이터 읽을 수 있다.
 *      200 HTTP1.1 ok
**/

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ServletInputStream inputStream = req.getInputStream();                                  // StringInput 으로 바이트를 얻을 수 있다.
            String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8 );    // StringUtill 라이브러리

            System.out.println("messageBody = "+ messageBody);

            resp.getWriter().write("messageBody = "+ messageBody);
    }

}


