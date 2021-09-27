package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 회원 입력 등록 컨트롤러
    @Override
    public ModelView process(Map<String, Object> paramMap) throws ServletException, IOException {

        String username = (String) paramMap.get("username");
        int age = (int) paramMap.get("age");

        Member member = new Member( username,age );
        memberRepository.save( member );

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
//        request.setAttribute( "member", member );
//        String viewPath = "/WEB-INF/views/save-result.jsp";
////        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
////        dispatcher.forward(request, response);
//        return new MyView(viewPath);
        return null;
    }
}
