package hello.servlet.web.frontcontroller.v3;




import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

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
@WebServlet(name="FrontControllerServletV2",urlPatterns = "/front-controller/v3/*")
class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV1Map = new HashMap<>();

    public FrontControllerServletV3(){
        controllerV1Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3() );
        controllerV1Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3() );
        controllerV1Map.put("/front-controller/v3/members", new MemberListControllerV3() );
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1 구동 테스트");

        String requestURI = req.getRequestURI();

        ControllerV3 controller = controllerV1Map.get( requestURI );
        if( controller == null ){
            resp.setStatus( HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String,Object> paramMap = createParamMap(req);
        ModelView mv = controller.process( paramMap );

        String viewName = mv.getViewName();
        MyView myView = new MyView(viewName);


        req.getRequestDispatcher(viewName);

        
    }

    private Map<String,Object> createParamMap( HttpServletRequest request){
        Map<String,Object > paramMap = new HashMap<>();
        request.getHeaderNames().asIterator()
            .forEachRemaining(pramName -> paramMap.put( pramName, request.getParameter(pramName) ));
        return paramMap;
    };

}
