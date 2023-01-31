package LoginTests;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract  class TestBase {
    @BeforeMethod(alwaysRun = true)
    public void handleTestMethodName(Method method) {
        String testName = method.getName();
        //log.info("currently running test: " + this.getClass().getSimpleName() + ":" + testName);
    }
}
