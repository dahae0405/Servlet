package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.v2.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import org.apache.catalina.util.ParameterMap;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    // 회원 입력 폼 컨트롤러
    @Override
    public ModelView process(Map<String,Object> paramMap) throws ServletException, IOException{
        ModelView mv = new ModelView("new-form");
        return mv;
    }

}
