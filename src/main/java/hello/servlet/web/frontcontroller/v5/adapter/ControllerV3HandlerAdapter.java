package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) { //여기다.
        // MemberFormControllerV3 <- 얘는 ControllerV3 의 인스턴스이다. MemberFormControllerV3 는 부모로 ControllerV3 가 있다. 따라서 true 가 반횐됨.
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // handler = MemberFormControllerV3
        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = creatParaMap(request);
        ModelView mv = controller.process(paramMap); //MemberFormControllerV3 의 process 가 호출됨.

        return mv;
    }

    private Map<String, String> creatParaMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
