package runners;


import io.cucumber.java.Scenario;
import org.junit.Before;

import java.text.MessageFormat;

public class Hook {

    @Before()
    public void beforeScenario(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(MessageFormat.format("Starting - {0}", scenario.getName()));
        System.out.println("------------------------------");
    }
}
