package runCucumberTest;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "steps"
        //tags = "@tag1 or @tag2 or @tag3"
        // tags = "@appium1 or @appium2 or @appium3"
        ////tags = "@signup1 or @signup2 or @signup3"
)

public class runTest {

}
