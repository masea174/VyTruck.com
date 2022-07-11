package com.vytrack.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
        "rerun:target/rerun.txt",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/report.json"
        },
        features="src/test/resources/features",
        glue ="com/vytrack/step_definitions",
        dryRun = false,
        tags =""


)
public class CukesRunner {

}
