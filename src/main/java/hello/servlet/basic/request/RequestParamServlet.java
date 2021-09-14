package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  1. 파라미터 전송 기능
 *  http://localhost:8080/request-param?username=hello&age=20&username=kim
 *
 *  2. 키단수/복수 와 값복수 파라미터 조회 구현법
 *
 * **/

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 기본 샛팅 / 샛팅 테스트 ( 구동및 출력 )
        System.out.println("servlet test");
        req.getParameterNames();

        // 2. 모든 파라미터 조회
        System.out.println("전체 파라미터 조회 ( Iterator로 돌린 다음, forEaxh를 사용하는 경우 ) [Names -> 배 반환 ] ");
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "="+ req.getParameter(paramName )));



        // 3. 특정 파라미터 조회
        System.out.println("특정 파라미터 조회 [Parmeter -> String 반환 ]");
        String username = req.getParameter("username");

        System.out.println("username = "+ username);


        // 4. 특정 파라미터의 동일 키에 복수값 조회.
        System.out.println("특정 파라미터의 동일키에 복수값 조회 [Values -> Array로 반환 ]");
        String[] usernames = req.getParameterValues("username");
        for( String name : usernames ){
            System.out.println( "username = "+ name);
        }

        // 2.

    }

}
