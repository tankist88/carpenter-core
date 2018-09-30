package com.github.tankist88.carpenter.core.property;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.github.tankist88.carpenter.core.property.GenerationPropertiesFactory.loadProps;
import static org.testng.Assert.*;

public class GenerationPropertiesFactoryTest {
    @Test
    public void testLoadAllowedPackagesForDp() {
        String[] arr = loadProps().getAllowedPackagesForDp();
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
        String[] arr = loadProps().getAllowedPackagesForTests();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "com.github.tankist88.carpenter",
                "com.github.tankist88.carpenter.core.property.GenerationPropertiesFactoryTest",
                "com.github.tankist88.carpenter.core.property.converter.BooleanConverter",
                "com.github.tankist88.carpenter.core.property.converter.IntegerConverter",
                "com.github.tankist88.carpenter.core.property.converter.StringConverter",
                "com.github.tankist88.carpenter.core.property.converter.PropConverter",
                "com.github.tankist88.carpenter.core.property.converter.UtGenConverter",
                "com.github.tankist88.carpenter.core.property.converter.ObjectDumpConverter",
                "com.github.tankist88.carpenter.core.util.PropertyUtils",
                "com.github.tankist88.carpenter.core.property.AbstractGenerationProperties",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodCallTraceInfo",
                "com.github.tankist88.carpenter.core.property.FileGenerationProperties",
                "com.github.tankist88.carpenter.core.property.XmlGenerationProperties",
                "com.github.tankist88.carpenter.core.property.GenerationPropertiesFactory",
                "com.github.tankist88.carpenter.core.dto.trace.TraceAnalyzeDto",
                "com.github.tankist88.carpenter.core.property.GenerationProperties",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodBaseInfo",
                "com.github.tankist88.carpenter.core.dto.argument.GeneratedArgument",
                "com.github.tankist88.carpenter.core.dto.unit.ClassInfo",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodCallInfo",
                "com.github.tankist88.carpenter.core.exception.CallerNotFoundException",
                "com.github.tankist88.carpenter.core.dto.unit.field.FieldBaseInfo",
                "com.github.tankist88.carpenter.core.util.TypeHelper",
                "com.github.tankist88.carpenter.core.dto.unit.AbstractUnitBaseInfo",
                "com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties",
                "com.github.tankist88.carpenter.core.util.ConvertUtil",
                "com.github.tankist88.carpenter.core.dto.argument.AbstractArgument",
                "com.github.tankist88.carpenter.core.dto.unit.ClassBaseInfo"
        );
        for (String p : arr) {
            assertTrue(controlValues.contains(p), "Package \"" + p + "\" not contains in control list");
        }
    }

    @Test
    public void testLoadAllowedClassesForTraceCollect() {
        String[] arr = loadProps().getAllowedClassesForTraceCollect();
        assertNotEquals(arr.length, 0);
        List<String> controlValues = Arrays.asList(
                "com.github.tankist88.carpenter.core.property.GenerationPropertiesFactoryTest",
                "com.github.tankist88.carpenter.core.property.converter.BooleanConverter",
                "com.github.tankist88.carpenter.core.property.converter.IntegerConverter",
                "com.github.tankist88.carpenter.core.property.converter.StringConverter",
                "com.github.tankist88.carpenter.core.property.converter.PropConverter",
                "com.github.tankist88.carpenter.core.property.converter.UtGenConverter",
                "com.github.tankist88.carpenter.core.property.converter.ObjectDumpConverter",
                "com.github.tankist88.object2source.dto.ProviderResult",
                "com.github.tankist88.carpenter.core.property.AbstractGenerationProperties",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodCallTraceInfo",
                "com.github.tankist88.carpenter.core.property.FileGenerationProperties",
                "com.github.tankist88.carpenter.core.property.XmlGenerationProperties",
                "com.github.tankist88.carpenter.core.property.GenerationPropertiesFactory",
                "com.github.tankist88.carpenter.core.dto.trace.TraceAnalyzeDto",
                "com.github.tankist88.carpenter.core.property.GenerationProperties",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodBaseInfo",
                "com.github.tankist88.carpenter.core.dto.argument.GeneratedArgument",
                "com.github.tankist88.carpenter.core.dto.unit.ClassInfo",
                "com.github.tankist88.carpenter.core.dto.unit.method.MethodCallInfo",
                "com.github.tankist88.carpenter.core.exception.CallerNotFoundException",
                "com.github.tankist88.carpenter.core.dto.unit.field.FieldBaseInfo",
                "com.github.tankist88.carpenter.core.util.TypeHelper",
                "com.github.tankist88.carpenter.core.dto.unit.AbstractUnitBaseInfo",
                "com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties",
                "com.github.tankist88.carpenter.core.util.ConvertUtil",
                "com.github.tankist88.carpenter.core.util.PropertyUtils",
                "com.github.tankist88.carpenter.core.dto.argument.AbstractArgument",
                "com.github.tankist88.carpenter.core.dto.unit.ClassBaseInfo"
        );
        for (String c : arr) {
            assertTrue(controlValues.contains(c), "Class \"" + c + "\" not contains in control list");
        }
    }

    @Test
    public void testExcludedPackagesForTraceCollect() {
        String[] arr = loadProps().getExcludedPackagesForTraceCollect();
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
        String[] classNames = loadProps().getExternalExtensionClassNames();
        assertEquals(classNames, new String[] {"org.com.sun.a", "org.com.sun.b"});
    }

    @Test
    public void testGetMaxObjectDepth() {
        assertEquals(loadProps().getMaxObjectDepth(), 15);
    }

    @Test
    public void testGetCollectorThreadPoolSize() {
        assertEquals(loadProps().getCollectorThreadPoolSize(), 70);
    }

    @Test
    public void testGetEncoding() {
        assertEquals(loadProps().getEncoding(), "windows-1251");
    }
}
