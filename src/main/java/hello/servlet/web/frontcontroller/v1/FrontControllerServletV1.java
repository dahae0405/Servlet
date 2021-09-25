package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  1. FrontControllerServletV1 도입
 *
 *  ㄴ FrontControllerServletV1 : URI 매핑 정보 수집
 *
 *  ㄴ service :  [[공통 처리]]
 *
 *
 *  2. controller 인터페이스 도입
 *
 *  ㄴ ControllerV1 : [[정의]]
 *
 *  ㄴ 입력폼 / 목록 / 저장은 컨트롤로 개별파일로 개발.
 *

 * **/
@WebServlet(name="FrontControllerServletV1",urlPatterns = "/front-controller/v1/*")
class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public FrontControllerServletV1(){
        controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1() );
        controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1() );
        controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1() );
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1 구동 테스트");

        String requestURI = req.getRequestURI();

        ControllerV1 controller = controllerV1Map.get( requestURI );
        if( controller == null ){
            resp.setStatus( HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process( req, resp);
        
    }
}
