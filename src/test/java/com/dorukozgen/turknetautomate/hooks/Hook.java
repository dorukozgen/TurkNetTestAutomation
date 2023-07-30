package com.dorukozgen.turknetautomate.hooks;

import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    @Before
    public void beforeScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(s -> s.equals("@desktop"))) {
            DesktopDriverManagement.getInstance().launch();
        }

        System.out.println("Senaryo başladı, senaryo adı: " + scenario.getName());
    }


    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.getSourceTagNames().stream().anyMatch(s -> s.equals("@desktop"))) {
            DesktopDriverManagement.getInstance().destroy();
        }

        System.out.println("Senaryo bitti, senaryo adı: " + scenario.getName());
    }
}
