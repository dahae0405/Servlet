package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  자바코드와 HTML코드 분리
 *
 *  - 컨트롤러
 *  ㄴ 비즈니스 로직 추가
 *  ㄴ (*추가) 뷰 포워딩 기능 추가
 *  ㄴ (*추가) 뷰용 서블릿 모델 기능 추가.
 *  - jsp
 *  ㄴ HTML 코드 작성
 *
 *  - 리다이렉트 VS 포워드
 *  ㄴ 리다이렉트 : 브라우저에 응답이 나갔다가 클라이언트가 리다이렉트 경로로 다시 요청. ( 따라서, 클라이언트가 인지할 수 있고, url 경로도 변경)
 *  ㄴ 포워드 : 서버 내부에서 일어나는 호출로, 클라이언트가 인지 하지 못한다.
 *
 * **/
@WebServlet( name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class mvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath );
        dispatcher.forward(req, resp);
        
    }
}
