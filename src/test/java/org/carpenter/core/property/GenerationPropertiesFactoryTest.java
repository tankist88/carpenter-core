package org.carpenter.core.property;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GenerationPropertiesFactoryTest {
    private void printStringArray(String[] arr) {
        for(String s : arr) {
            System.out.println(s);
        }
    }
    @Test
    public void testLoadProps() {
        System.out.println("----------------------");
        System.out.println("| EXCLUDED FOR DP    |");
        System.out.println("----------------------");
        printStringArray(GenerationPropertiesFactory.loadProps().getExcludedPackagesForDp());
        System.out.println("----------------------");
        System.out.println("| ALLOWED FOR TESTS  |");
        System.out.println("----------------------");
        printStringArray(GenerationPropertiesFactory.loadProps().getAllowedPackagesForTests());
        System.out.println("----------------------");
        System.out.println("| EXCLUDED FOR TRACE  |");
        System.out.println("----------------------");
        printStringArray(GenerationPropertiesFactory.loadProps().getExcludedPackagesForTraceCollect());
    }

    @Test
    public void testGetExternalExtensionClassNames() {
        String[] classNames = GenerationPropertiesFactory.loadProps().getExternalExtensionClassNames();
        assertEquals(classNames, new String[] {"org.com.sun.a", "org.com.sun.b"});
    }
}
