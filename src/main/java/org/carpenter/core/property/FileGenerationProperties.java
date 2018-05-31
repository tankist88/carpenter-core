package org.carpenter.core.property;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class FileGenerationProperties extends AbstractGenerationProperties {
    private static final String PROPERTY_FILE = "carpenter.properties";

    FileGenerationProperties() {
        try {
            Properties prop = new Properties();

            String jarFilePath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getPath();
            File propFile = new File(jarFilePath, PROPERTY_FILE);

            if(propFile.exists()) {
                // use by generator
                prop.load(new FileInputStream(propFile));
            } else {
                // use by collector
                prop.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE));
            }

            this.utGenDir = prop.getProperty("ut.gen.dir");
            if (StringUtils.isBlank(this.utGenDir) || this.utGenDir.equals("tmp")) {
                this.utGenDir = System.getProperty("java.io.tmpdir") + "/ut_gen";
            }
            this.dataProviderClassPattern = prop.getProperty("data.providers.class.pattern");
            if (StringUtils.isBlank(this.dataProviderClassPattern)) {
                this.dataProviderClassPattern = DEFAULT_DATA_PROVIDER_CLASS_PATTERN;
            }
            allowedPackagesForTests = getArrayProperty(prop, "test.generation.allowed.packages");
            excludedPackagesForDp = getArrayProperty(prop, "data.providers.excluded.packages");
            excludedPackagesForTraceCollect = getArrayProperty(prop, "trace.collect.excluded.packages");
            this.objectDumpDir = (String) prop.get("object.dump.dir");
            if (this.objectDumpDir == null || this.objectDumpDir.equals("tmp")) {
                this.objectDumpDir = System.getProperty("java.io.tmpdir") + "/trace_dump";
            }
        } catch (Exception iex) {
            iex.printStackTrace();
        }
    }

    private String[] getArrayProperty(Properties prop, String parameterName) {
        List<String> values = new ArrayList<>();
        int i = 1;
        while(true) {
            String value = prop.getProperty(parameterName + "_" + i);
            if(value != null) {
                values.add(value.replaceAll(" ", "").trim());
            } else {
                break;
            }
            i++;
        }
        return values.toArray(new String[0]);
    }
}
