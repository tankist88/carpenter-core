package org.carpenter.core.property;

public class GenerationPropertiesFactory {
    private static GenerationProperties cachedProps;

    public static synchronized GenerationProperties loadProps() {
        if(cachedProps == null) {
            cachedProps = new FileGenerationProperties();
        }
        return cachedProps;
    }
}
