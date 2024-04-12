package hello.survlet.web.frontcontroller.v3.controller;

import hello.survlet.web.frontcontroller.ModelView;
import hello.survlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paraMap) {
        return new ModelView("new-form");
    }
}
