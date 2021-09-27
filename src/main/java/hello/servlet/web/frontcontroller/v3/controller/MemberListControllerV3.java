package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.MyView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v3.ModelView;
import org.springframework.boot.Banner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 회원 입력 등록 컨트롤러
    @Override
    public ModelView process(Map<String, Object> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        //request.setAttribute( "members", members );

        //String viewPath = "/WEB-INF/views/members.jsp";
        // //RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // //dispatcher.forward(request, response);
        //return new MyView(viewPath);

        ModelView mv  = new ModelView("members");
        mv.getModel().put("members",members);
        return mv;
    }
}
