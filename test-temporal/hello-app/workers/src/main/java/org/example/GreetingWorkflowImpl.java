package org.example;

import io.temporal.activity.ActivityOptions;
import io.temporal.internal.retryer.GrpcRetryer;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class GreetingWorkflowImpl implements GreetingWorkflow{

    private final HelloActivity activities =
            Workflow.newActivityStub(
                    HelloActivity.class,
                    ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(2)).build());
    @Override
    public String getGreeting(String name) {
        activities.composeGreeting2("","");
        return activities.composeGreeting("Hello",name);
    }
}
