package com.twitch.test.steps;

import com.twitch.test.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;


public class Hooks {


    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("SCENARIO " + scenario.getName() + " STARTED");
        Drivers.startDriver();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        Drivers.processExecutedScenario(scenario);
    }
}
