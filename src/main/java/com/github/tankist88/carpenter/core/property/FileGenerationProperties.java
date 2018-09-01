package com.github.tankist88.carpenter.core.property;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

class FileGenerationProperties extends AbstractGenerationProperties {
    FileGenerationProperties(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void loadProps(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        utGenDir = prop.getProperty("ut.gen.dir");
        if (StringUtils.isBlank(utGenDir) || utGenDir.equals("tmp")) {
            utGenDir = System.getProperty("java.io.tmpdir") + "/ut_gen";
        }
        dataProviderClassPattern = prop.getProperty("data.providers.class.pattern");
        if (StringUtils.isBlank(dataProviderClassPattern)) {
            this.dataProviderClassPattern = DEFAULT_DATA_PROVIDER_CLASS_PATTERN;
        }
        allowedPackagesForTests = getArrayProperty(prop, "test.generation.allowed.packages");
        allowedPackagesForDp = getArrayProperty(prop, "data.providers.allowed.packages");
        excludedPackagesForTraceCollect = getArrayProperty(prop, "trace.collect.excluded.packages");
        externalExtensionClassNames = getArrayProperty(prop, "external.extension.class.names");
        externalAssertExtensionClassNames = getArrayProperty(prop, "external.assert.extension.class.names");
        excludedThreadNames = getArrayProperty(prop, "excluded.thread.names");
        objectDumpDir = (String) prop.get("object.dump.dir");
        if (objectDumpDir == null || objectDumpDir.equals("tmp")) {
            objectDumpDir = System.getProperty("java.io.tmpdir") + "/trace_dump";
        }
        String fillTestClassInstanceStr = (String) prop.get("fill.test.class.instance");
        if (fillTestClassInstanceStr != null) {
            fillTestClassInstance = Boolean.parseBoolean(fillTestClassInstanceStr);
        }
        String noZeroArgConstructorTestAllowedStr = (String) prop.get("no.zero.arg.constructor.test.allowed");
        if (noZeroArgConstructorTestAllowedStr != null) {
            noZeroArgConstructorTestAllowed = Boolean.parseBoolean(noZeroArgConstructorTestAllowedStr);
        }
        String maxObjectDepthStr = (String) prop.get("max.object.depth");
        if (maxObjectDepthStr != null) {
            maxObjectDepth = Integer.parseInt(maxObjectDepthStr);
        } else {
            maxObjectDepth = 10;
        }
        String collectorThreadPoolSizeStr = (String) prop.get("collector.thread.pool.size");
        if (collectorThreadPoolSizeStr != null) {
            collectorThreadPoolSize = Integer.parseInt(collectorThreadPoolSizeStr);
        } else {
            collectorThreadPoolSize = 55;
        }
    }

    private String[] getArrayProperty(Properties prop, String parameterName) {
        List<String> values = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            String key = (String) entry.getKey();
            if (!key.startsWith(parameterName)) continue;
            String value = prop.getProperty(key);
            if (value != null) {
                values.add(value.replace(" ", "").trim());
            }
        }
        return values.toArray(new String[0]);
    }
}
