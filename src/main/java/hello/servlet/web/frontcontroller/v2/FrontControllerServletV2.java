package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  -v2
 *  ㄴ V1에서 디스패처를 리펙토리
 *
 *  리펙토리
 *  ㄴ 뷰 클래스 =  MYVIEW는 뷰 관리모델 + 뷰 디스패처 기능
 *
 *  -V1
 *  ㄴ 모든 요청은 프론트 컨트롤러
 *  ㄴ 요청 분담은 URI별 컨트롤러명로 매핑
 *

 * **/
@WebServlet(name="FrontControllerServletV2",urlPatterns = "/front-controller/v2/*")
class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV1Map = new HashMap<>();

    public FrontControllerServletV2(){
        controllerV1Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2() );
        controllerV1Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2() );
        controllerV1Map.put("/front-controller/v2/members", new MemberListControllerV2() );
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1 구동 테스트");

        String requestURI = req.getRequestURI();

        ControllerV2 controller = controllerV1Map.get( requestURI );
        if( controller == null ){
            resp.setStatus( HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process( req, resp);
        view.render(req, resp);
        
    }
}
