package moon.mvc1.web.frontcontroller.v5;

import moon.mvc1.web.frontcontroller.ModelView;
import moon.mvc1.web.frontcontroller.MyView;
import moon.mvc1.web.frontcontroller.v3.ControllerV3;
import moon.mvc1.web.frontcontroller.v3.controller.MemberFormControllerV3;
import moon.mvc1.web.frontcontroller.v3.controller.MemberListControllerV3;
import moon.mvc1.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import moon.mvc1.web.frontcontroller.v4.controller.MemberFormControllerV4;
import moon.mvc1.web.frontcontroller.v4.controller.MemberListControllerV4;
import moon.mvc1.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import moon.mvc1.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import moon.mvc1.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    private final Map<String,Object> handlerMapingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();
    public FrontControllerServletV5() {
        initHandlerMappingMap();

        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMapingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMapingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMapingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //v4 추가
        handlerMapingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMapingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMapingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
          handlerAdapters.add(new ControllerV3HandlerAdapter());
         handlerAdapters.add(new ControllerV4HandlerAdapter());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request);
        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);


        String viewName = mv.getViewName(); //view 논리이름
        MyView View = viewResolver(viewName);
        View.render(mv.getModel(),request,response);

    }


    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        Object handler = handlerMapingMap.get(requestURI);
        return handler;
    }
    private MyHandlerAdapter getHandlerAdapter(Object handler) {

        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)){
                return adapter;
            }
        } throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler = " + handler);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

}
