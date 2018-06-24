package org.carpenter.core.property;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class GenerationPropertiesFactoryTest {
    @Test
    public void testLoadExcludedPackagesForDp() {
        String[] arr = GenerationPropertiesFactory.loadProps().getExcludedPackagesForDp();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "net",
                "com"
        );
        for (String p : arr) {
            assertTrue(controlValues.contains(p), "Package \"" + p + "\" not contains in control list");
        }
    }

    @Test
    public void testLoadAllowedPackagesForTests() {
        String[] arr = GenerationPropertiesFactory.loadProps().getAllowedPackagesForTests();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "org.carpenter",
                "org.carpenter.core.property.GenerationPropertiesFactoryTest",
                "org.carpenter.core.property.AbstractGenerationProperties",
                "org.carpenter.core.dto.unit.method.MethodCallTraceInfo",
                "org.carpenter.core.property.FileGenerationProperties",
                "org.carpenter.core.property.XmlGenerationProperties",
                "org.carpenter.core.property.GenerationPropertiesFactory",
                "org.carpenter.core.dto.trace.TraceAnalyzeDto",
                "org.carpenter.core.property.GenerationProperties",
                "org.carpenter.core.dto.unit.method.MethodBaseInfo",
                "org.carpenter.core.dto.argument.GeneratedArgument",
                "org.carpenter.core.dto.unit.ClassInfo",
                "org.carpenter.core.dto.unit.method.MethodCallInfo",
                "org.carpenter.core.exception.CallerNotFoundException",
                "org.carpenter.core.dto.unit.field.FieldBaseInfo",
                "org.carpenter.core.util.TypeHelper",
                "org.carpenter.core.dto.unit.AbstractUnitBaseInfo",
                "org.carpenter.core.dto.unit.field.FieldProperties",
                "org.carpenter.core.util.ConvertUtil",
                "org.carpenter.core.dto.argument.AbstractArgument",
                "org.carpenter.core.dto.unit.ClassBaseInfo"
        );
        for (String p : arr) {
            assertTrue(controlValues.contains(p), "Package \"" + p + "\" not contains in control list");
        }
    }

    @Test
    public void testLoadAllowedClassesForTraceCollect() {
        String[] arr = GenerationPropertiesFactory.loadProps().getAllowedClassesForTraceCollect();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "org.carpenter.core.property.GenerationPropertiesFactoryTest",
                "org.object2source.dto.ProviderResult",
                "org.carpenter.core.property.AbstractGenerationProperties",
                "org.carpenter.core.dto.unit.method.MethodCallTraceInfo",
                "org.carpenter.core.property.FileGenerationProperties",
                "org.carpenter.core.property.XmlGenerationProperties",
                "org.carpenter.core.property.GenerationPropertiesFactory",
                "org.carpenter.core.dto.trace.TraceAnalyzeDto",
                "org.carpenter.core.property.GenerationProperties",
                "org.carpenter.core.dto.unit.method.MethodBaseInfo",
                "org.carpenter.core.dto.argument.GeneratedArgument",
                "org.carpenter.core.dto.unit.ClassInfo",
                "org.carpenter.core.dto.unit.method.MethodCallInfo",
                "org.carpenter.core.exception.CallerNotFoundException",
                "org.carpenter.core.dto.unit.field.FieldBaseInfo",
                "org.carpenter.core.util.TypeHelper",
                "org.carpenter.core.dto.unit.AbstractUnitBaseInfo",
                "org.carpenter.core.dto.unit.field.FieldProperties",
                "org.carpenter.core.util.ConvertUtil",
                "org.carpenter.core.dto.argument.AbstractArgument",
                "org.carpenter.core.dto.unit.ClassBaseInfo"
        );
        for (String c : arr) {
            assertTrue(controlValues.contains(c), "Class \"" + c + "\" not contains in control list");
        }
    }

    @Test
    public void testExcludedPackagesForTraceCollect() {
        String[] arr = GenerationPropertiesFactory.loadProps().getExcludedPackagesForTraceCollect();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "sun"
        );
        for (String p : arr) {
            assertTrue(controlValues.contains(p), "Package \"" + p + "\" not contains in control list");
        }
    }

    @Test
    public void testGetExternalExtensionClassNames() {
        String[] classNames = GenerationPropertiesFactory.loadProps().getExternalExtensionClassNames();
        assertEquals(classNames, new String[] {"org.com.sun.a", "org.com.sun.b"});
    }
}
