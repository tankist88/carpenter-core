package com.github.tankist88.carpenter.core.property;

import com.github.tankist88.carpenter.core.property.converter.ObjectDumpConverter;
import com.github.tankist88.carpenter.core.property.converter.UtGenConverter;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

import static com.github.tankist88.carpenter.core.util.PropertyUtils.*;

public class XmlGenerationProperties extends AbstractGenerationProperties {
    XmlGenerationProperties(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void loadProps(InputStream inputStream) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        String utGenDirDefault = System.getProperty("java.io.tmpdir") + "/ut_gen";
        String objectDumpDirDefault = System.getProperty("java.io.tmpdir") + "/trace_dump";

        utGenDir = getSingleProperty(document, "utGenDir", utGenDirDefault, new UtGenConverter());
        dataProviderClassPattern = getStringProperty(document, "dataProviderClassPattern", DEFAULT_DATA_PROVIDER_CLASS_PATTERN);
        allowedPackagesForTests = getArrayProperty(document, "allowedPackagesForTests");
        allowedPackagesForDp = getArrayProperty(document, "allowedPackagesForDp");
        excludedPackagesForTraceCollect = getArrayProperty(document, "excludedPackagesForTraceCollect");
        externalExtensionClassNames = getArrayProperty(document, "externalExtensionClassNames");
        externalAssertExtensionClassNames = getArrayProperty(document, "externalAssertExtensionClassNames");
        excludedThreadNames = getArrayProperty(document, "excludedThreadNames");
        objectDumpDir = getSingleProperty(document, "objectDumpDir", objectDumpDirDefault, new ObjectDumpConverter());
        fillTestClassInstance = getBooleanProperty(document, "fillTestClassInstance", false);
        noZeroArgConstructorTestAllowed = getBooleanProperty(document, "noZeroArgConstructorTestAllowed", false);
        createMockFields = getBooleanProperty(document, "useAnnotationMockStyle", false);
        usePowermock = getBooleanProperty(document, "usePowermock", false);
        maxObjectDepth = getIntegerProperty(document, "maxObjectDepth", DEFAULT_MAX_OBJECT_DEPTH);
        collectorThreadPoolSize = getIntegerProperty(document, "collectorThreadPoolSize", DEFAULT_THREAD_POOL_SIZE);
        encoding = getStringProperty(document, "encoding", DEFAULT_ENCODING);
        targetMockitoVersion = getStringProperty(document, "targetMockitoVersion", DEFAULT_MOCKITO_VERSION);
    }

    private String[] getArrayProperty(Document document, String propName) {
        List<Node> nodes = document.selectNodes("/carpenterConfig/" + propName + "/value");
        int size = nodes != null ? nodes.size() : 0;
        String[] arr = new String[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nodes.get(i).getText();
        }
        return arr;
    }
}
