package ua.pr6;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeTags("parameter")
@SelectClasses(TextProcessorTest.class)
public class ParameterTest {
}