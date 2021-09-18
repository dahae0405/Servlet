package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.Lombock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *  HttpServlet 상속
 *
 *  문자로 받고 (stream )
 *  문자로 준다 (content-type 설정해서 형태 바꾸기 )
 *
 *  여기서 추후, 스프링 mvc를 적용하면
 *          contentType 제거,
 *          response에 응답 싣기 위한 문자 파싱 objectMapper 코드가 return lombock으로 제거된다.
 *
 *
 * **/
@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class responseJsonServlet extends HttpServlet {

    ObjectMapper ob = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ContentType : application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        Lombock lomData = new Lombock();
        lomData.setUsername("kim");
        lomData.setAge(20);

        // {"username":"kim", "age": 20 }
        String result = ob.writeValueAsString( lomData );
        response.getWriter().write( result );

        // 웹브라우저 > url요청 후 > 웹브라우저의 소스보기 > { "username":"kim", "age":20 } 출력 확인


    }

}
