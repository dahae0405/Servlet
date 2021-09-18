package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


/**
 *  HttpServlet 상속
 *
 *  1. content 타입 먼저 잡아주기
 *  2. 한글 깨짐 잡아주기
 *
 *  1와2 결과
 *  - 초기값. 웹브라우저 > 소스보기
         <html>
            <body>
                <div>안녕</div>
            </body>
         </html>

    - 브라우저가 랜더링을 한 경우
        안녕?
 *
 * **/
@WebServlet(name="responseHtmlServlet", urlPatterns = "/response-html")
public class responseHtmlServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("    <div>안녕</div>");
        writer.println("</body>");
        writer.println("</html>");


    }

}
