package moon.mvc1.web.frontcontroller.v3.controller;

import moon.mvc1.web.frontcontroller.ModelView;
import moon.mvc1.web.frontcontroller.MyView;
import moon.mvc1.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String,String> paramMap) throws ServletException, IOException {


        return new ModelView("new-form");
    }
}
