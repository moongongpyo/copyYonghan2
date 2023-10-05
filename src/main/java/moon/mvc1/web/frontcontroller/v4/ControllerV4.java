package moon.mvc1.web.frontcontroller.v4;

import moon.mvc1.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV4 {
    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    String process(Map<String,String> paramMap,Map<String,Object> model);

}
