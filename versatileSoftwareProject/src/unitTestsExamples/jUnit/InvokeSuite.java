package unitTestsExamples.jUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ AssertionExamples.class, BasicAnnotationExample.class, ParametrisedTestExamples.class })

public class InvokeSuite {
}
