package org.carpenter.core.property;

import org.testng.annotations.Test;

public class GenerationPropertiesFactoryTest {
    @Test
    public void testLoadProps() {
        System.out.println("----------------------");
        System.out.println("| EXCLUDED FOR DP    |");
        System.out.println("----------------------");
        prindStringArray(GenerationPropertiesFactory.loadProps().getExcludedPackagesForDp());
        System.out.println("----------------------");
        System.out.println("| ALLOWED FOR TESTS  |");
        System.out.println("----------------------");
        prindStringArray(GenerationPropertiesFactory.loadProps().getAllowedPackagesForTests());
        System.out.println("----------------------");
        System.out.println("| EXCLUDED FOR TRACE  |");
        System.out.println("----------------------");
        prindStringArray(GenerationPropertiesFactory.loadProps().getExcludedPackagesForTraceCollect());
    }

    private void prindStringArray(String[] arr) {
        for(String s : arr) {
            System.out.println(s);
        }
    }
}
