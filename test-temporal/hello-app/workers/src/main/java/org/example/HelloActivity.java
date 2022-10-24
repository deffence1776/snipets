package org.example;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ActivityInterface
public interface HelloActivity {

    @ActivityMethod(name = "greet")
    String composeGreeting(String greeting, String name);
    @ActivityMethod(name = "greet2")
    String composeGreeting2(String greeting, String name);


    static class HelloActivityImpl implements HelloActivity {
        private static final Logger log = LoggerFactory.getLogger(HelloActivityImpl.class);

        @Override
        public String composeGreeting2(String greeting, String name) {
           return "hey";
        }

        @Override
        public String composeGreeting(String greeting, String name) {
            log.info("Composing greeting...");
            System.out.println("Composing greeting...");
            return greeting + " " + name + "!";
        }
    }
}
