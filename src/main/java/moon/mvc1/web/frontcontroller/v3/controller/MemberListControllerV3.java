package moon.mvc1.web.frontcontroller.v3.controller;

import moon.mvc1.domain.member.Member;
import moon.mvc1.domain.member.MemberRepository;
import moon.mvc1.web.frontcontroller.ModelView;
import moon.mvc1.web.frontcontroller.MyView;
import moon.mvc1.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String,String> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members",members);

        return mv;
    }
}
