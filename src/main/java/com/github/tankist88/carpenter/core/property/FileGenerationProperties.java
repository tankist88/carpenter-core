package com.github.tankist88.carpenter.core.property;

import com.github.tankist88.carpenter.core.property.converter.ObjectDumpConverter;
import com.github.tankist88.carpenter.core.property.converter.UtGenConverter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.github.tankist88.carpenter.core.util.PropertyUtils.*;

class FileGenerationProperties extends AbstractGenerationProperties {
    FileGenerationProperties(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void loadProps(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);

        String utGenDirDefault = System.getProperty("java.io.tmpdir") + "/ut_gen";
        String objectDumpDirDefault = System.getProperty("java.io.tmpdir") + "/trace_dump";

        utGenDir = getSingleProperty(prop, "ut.gen.dir", utGenDirDefault, new UtGenConverter());
        dataProviderClassPattern = getStringProperty(prop, "data.providers.class.pattern", DEFAULT_DATA_PROVIDER_CLASS_PATTERN);
        allowedPackagesForTests = getArrayProperty(prop, "test.generation.allowed.packages");
        allowedPackagesForDp = getArrayProperty(prop, "data.providers.allowed.packages");
        excludedPackagesForTraceCollect = getArrayProperty(prop, "trace.collect.excluded.packages");
        externalExtensionClassNames = getArrayProperty(prop, "external.extension.class.names");
        externalAssertExtensionClassNames = getArrayProperty(prop, "external.assert.extension.class.names");
        excludedThreadNames = getArrayProperty(prop, "excluded.thread.names");
        objectDumpDir = getSingleProperty(prop, "object.dump.dir", objectDumpDirDefault, new ObjectDumpConverter());
        fillTestClassInstance = getBooleanProperty(prop, "fill.test.class.instance", false);
        noZeroArgConstructorTestAllowed = getBooleanProperty(prop, "no.zero.arg.constructor.test.allowed", false);
        createMockFields = getBooleanProperty(prop, "use.annotation.mock.style", false);
        usePowermock = getBooleanProperty(prop, "use.powermock", false);
        maxObjectDepth = getIntegerProperty(prop, "max.object.depth", DEFAULT_MAX_OBJECT_DEPTH);
        collectorThreadPoolSize = getIntegerProperty(prop, "collector.thread.pool.size", DEFAULT_THREAD_POOL_SIZE);
        encoding = getStringProperty(prop, "encoding", DEFAULT_ENCODING);
        maxByteArrayLength = getIntegerProperty(prop, "max.byte.array.length", DEFAULT_MAX_BYTE_ARRAY_LENGTH);
        useNullValuesInArgumentMatchers = getBooleanProperty(prop, "use.null.values.in.argument.matchers", false);
    }

    private String[] getArrayProperty(Properties prop, String parameterName) {
        List<String> values = new ArrayList<String>();
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
