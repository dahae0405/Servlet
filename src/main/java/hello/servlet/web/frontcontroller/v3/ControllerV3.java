package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.v2.MyView;
import hello.servlet.web.frontcontroller.v3.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String,Object> paramMap) throws ServletException, IOException;

}
