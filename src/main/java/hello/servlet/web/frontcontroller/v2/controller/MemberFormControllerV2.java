package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.MyView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    // 회원 입력 폼 컨트롤러
    @Override
    public MyView process( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{
        String viewPath = "/WEB-INF/views/new-form.jsp";

        return new MyView(viewPath);
        //RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //dispatcher.forward(request, response);
    }

}
