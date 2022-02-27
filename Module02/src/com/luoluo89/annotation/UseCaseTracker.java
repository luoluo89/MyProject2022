package com.luoluo89.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCaseIds, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found UseCase: " + uc.id() + uc.description());
                for (Integer i : useCaseIds)
                {
                    if (i == uc.id())
                    {
                        useCaseIds.remove((Integer)uc.id());
                        break;
                    }
                }

            }
        }
        for (int i : useCaseIds) {
            System.out.println("Missing UseCase: " + i);
        }
    }


    public static void main(String[] args) {
        List<Integer> useCaseIds = new ArrayList<Integer>();
        Collections.addAll(useCaseIds, 111, 222, 333, 444);
        trackUseCases(useCaseIds, UseCaseTest.class);
    }
}
