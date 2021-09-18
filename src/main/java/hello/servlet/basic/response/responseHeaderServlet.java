package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *  HttpServlet 상속
 *
 *  1. 기본 응답 설정하기
 *      1-1. 상태 메세지 추가하기
 *      1-2. 해더에 응답타입, 프라그마 등등 추가하기
 *      1-3. 응답 생성하기
 *          처리 : getWriter().write()
 *
 *  2. 편의 메서드
 *      2-1. header key 매칭
 *          기존 : 수동 key value set
 *          변경 : HttpServletResponse 객체가 제공하는 key 매칭 get/set 사용하기
 *
 *      2-2. redirect key 매칭
 *          결과  : status code 302
 *                redirect html
 *          기존 : 수동 key value set
 *          변경 : sendRedirect가 제공하는 자동 key값 사용.
 *
 *      3-3. cookie key 매칭
 *          결과 : myCookie=good
 *          기존 : 수동 key value set
 *          편의 : cookie 라이브러리가 제공하는 cookie 형태로 정의된 (key값)을 제공.
 *
 * **/
@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class responseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [[status-line]] 1-1번 답
        response.setStatus(HttpServletResponse.SC_OK);

        // [[response-headers]]번 1-2번 답
        response.setHeader("Content-Type","text/plain");
        response.setHeader("Cache-Control","text/plain");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

        // [[편의 메서드]] 2번 답
        //content( response);
        //Cookie( response );
        //redirect( response );

        // 1-3번
        PrintWriter pw = response.getWriter();
        pw.write("ok");

    }

    // servletRes으로 대체
    private void content(HttpServletResponse response ){

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

    }

    private void Cookie( HttpServletResponse response ){
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        response.addCookie( cookie );   // = response.setHeader("Set-Cookie","myCookie=good; Max-age=600")

    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.setStatus( HttpServletResponse.SC_FOUND ); //  302
        //response.setHeader( "Location", "/basic/hello-form.html");

        response.sendRedirect( "/basic/hello-form.html" );

    }


}
