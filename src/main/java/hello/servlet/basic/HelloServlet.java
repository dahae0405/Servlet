package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *  HttpServlet 상속
 *
 *  servlet으로 요청 응답을 진행하여봄.
 *  ㄴ http스펙을 일일히 맞추기 어려운데, 서블릿이 자동으로 htp스펙을 일일히 맞춰준다.
 * **/
@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 출력1. servlet 구동
        System.out.println("HelloServlet");

        // 출력2. servlet 컨테이너에서 만든 servlet객체 출력
        // 원리. 위 요청시, 웹브라우저가 http메세지를 서블릿 컨테이너에 던짐, 서블릿 컨테이버는 servlet객체를 만들어 서버에 줌.
        // 결과. request = org.apache.catalina.connector.RequestFacade@438db73a ( 톰캣에서 사용하는 라이브러리가 출력된다.)
        System.out.println("request = "+request);
        System.out.println("response = "+response);

        // 출력3. 서블릿이 자동으로 파라미터 username을 자동으로 "파싱"해준다.
        String username = request.getParameter("username");
        System.out.println("username = "+username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);



    }
}
