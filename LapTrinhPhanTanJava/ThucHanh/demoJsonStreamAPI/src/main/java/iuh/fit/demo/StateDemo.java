package iuh.fit.demo;

import iuh.fit.entity.State;
import iuh.fit.handler.StateJsonHandler;

import java.util.List;

public class StateDemo {
    public static void main(String[] args) {

        List<State> states = StateJsonHandler.findByYear(1899);
        states.forEach(st -> System.out.println(st));
//        List<State> states = StateJsonHandler.getStates();
//        states.forEach(st -> System.out.println(st));
    	
//    	State st = StateJsonHandler.findByAb("al");
//    	System.out.println(st);

    }
}
