package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.MyView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 회원 입력 등록 컨트롤러
    @Override
    public MyView process(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException{

        List<Member> members = memberRepository.findAll();

        request.setAttribute( "members", members );

        String viewPath = "/WEB-INF/views/members.jsp";
        //RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //dispatcher.forward(request, response);
        return new MyView(viewPath);
    }

}
