package stepdefinitions;

import core.ScenarioContext;
import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {

        Allure.addAttachment(
                "Execution Info",
                "Scenario: " + scenario.getName() +
                        "\nThread: " + Thread.currentThread().getId()
        );
    }

    @After
    public void afterScenario(Scenario scenario) {

        Allure.addAttachment(
                "Execution End",
                "Scenario: " + scenario.getName() +
                        "\nThread: " + Thread.currentThread().getId()
        );
    }
}