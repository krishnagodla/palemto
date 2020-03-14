package examples1;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(JUnitPlatform.class)
@SelectPackages("examples1")
public class TestSuite {
  //nothing

System.out.println("This is a new LIne");
}