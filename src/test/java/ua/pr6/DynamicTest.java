package ua.pr6;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeTags("dynamic")
@SelectClasses(TextProcessorTest.class)
public class DynamicTest {
}