package hello.survlet.web.frontcontroller.v3;

import hello.survlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paraMap);
}
