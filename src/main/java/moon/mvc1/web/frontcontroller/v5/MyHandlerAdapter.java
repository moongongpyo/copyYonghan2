package moon.mvc1.web.frontcontroller.v5;

import moon.mvc1.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.HandshakeResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(Object handler);

   ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
