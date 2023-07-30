package com.dorukozgen.turknetautomate;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameters({
        @ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber-reports/DesktopTestReport.html"),
        @ConfigurationParameter(
                key = Constants.GLUE_PROPERTY_NAME,
                value = "com.dorukozgen.turknetautomate.stepDefinations.desktop,com.dorukozgen.turknetautomate.hooks"

        ),
        @ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "classpath:features"),
        @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@desktop")
})
public class DesktopTestRunner {



}
