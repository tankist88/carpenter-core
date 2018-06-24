package org.carpenter.core.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class GenerationPropertiesFactory {
    private static final String PROPERTY_FILE = "carpenter.properties";
    private static final String XML_FILE = "carpenter.xml";

    private static GenerationProperties cachedProps;

    public static synchronized GenerationProperties loadProps() {
        if(cachedProps == null) {
            try {
                InputStream xmlStream = getFileStream(XML_FILE);
                if (xmlStream != null) {
                    cachedProps = new XmlGenerationProperties(xmlStream);
                } else {
                    cachedProps = new FileGenerationProperties(getFileStream(PROPERTY_FILE));
                }
            } catch (Exception ex) {
                throw new IllegalStateException(ex);
            }
        }
        return cachedProps;
    }

    private static InputStream getFileStream(String filename) throws IOException, URISyntaxException {
        String jarFilePath = new File(GenerationPropertiesFactory.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getPath();
        File propFile = new File(jarFilePath, filename);
        if(propFile.exists()) {
            // use by generator
            return new FileInputStream(propFile);
        } else {
            // use by collector
            return GenerationPropertiesFactory.class.getClassLoader().getResourceAsStream(filename);
        }
    }
}
