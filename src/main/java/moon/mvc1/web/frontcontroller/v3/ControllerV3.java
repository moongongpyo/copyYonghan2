package moon.mvc1.web.frontcontroller.v3;

import moon.mvc1.web.frontcontroller.ModelView;
import moon.mvc1.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String,String> paramMap) throws ServletException, IOException;

}
