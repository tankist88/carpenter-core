package com.github.tankist88.carpenter.core.property;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlGenerationProperties extends AbstractGenerationProperties {
    XmlGenerationProperties(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public void loadProps(InputStream inputStream) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Node utGenDirNode = document.selectSingleNode("/carpenterConfig/utGenDir");
        utGenDir = utGenDirNode != null ? utGenDirNode.getText() : null;
        if (StringUtils.isBlank(utGenDir) || utGenDir.equals("tmp")) {
            utGenDir = System.getProperty("java.io.tmpdir") + "/ut_gen";
        }
        Node dpcNode = document.selectSingleNode("/carpenterConfig/dataProviderClassPattern");
        dataProviderClassPattern = dpcNode != null ? dpcNode.getText() : null;
        if (StringUtils.isBlank(dataProviderClassPattern)) {
            dataProviderClassPattern = DEFAULT_DATA_PROVIDER_CLASS_PATTERN;
        }
        allowedPackagesForTests = getArrayProperty(document, "allowedPackagesForTests");
        allowedPackagesForDp = getArrayProperty(document, "allowedPackagesForDp");
        excludedPackagesForTraceCollect = getArrayProperty(document, "excludedPackagesForTraceCollect");
        externalExtensionClassNames = getArrayProperty(document, "externalExtensionClassNames");
        externalAssertExtensionClassNames = getArrayProperty(document, "externalAssertExtensionClassNames");
        excludedThreadNames = getArrayProperty(document, "excludedThreadNames");
        Node objectDumpDirNode = document.selectSingleNode("/carpenterConfig/objectDumpDir");
        objectDumpDir = objectDumpDirNode != null ? objectDumpDirNode.getText() : null;
        if (objectDumpDir == null || objectDumpDir.equals("tmp")) {
            objectDumpDir = System.getProperty("java.io.tmpdir") + "/trace_dump";
        }
        Node fillTestClassInstanceNode = document.selectSingleNode("/carpenterConfig/fillTestClassInstance");
        String fillTestClassInstanceStr = fillTestClassInstanceNode != null ? fillTestClassInstanceNode.getText() : null;
        if (fillTestClassInstanceStr != null) {
            fillTestClassInstance = Boolean.parseBoolean(fillTestClassInstanceStr);
        }
        Node noZeroArgConstructorTestAllowedNode = document.selectSingleNode("/carpenterConfig/noZeroArgConstructorTestAllowed");
        String noZeroArgConstructorTestAllowedStr = noZeroArgConstructorTestAllowedNode != null ? noZeroArgConstructorTestAllowedNode.getText() : null;
        if (noZeroArgConstructorTestAllowedStr != null) {
            noZeroArgConstructorTestAllowed = Boolean.parseBoolean(noZeroArgConstructorTestAllowedStr);
        }
        Node maxObjectDepthNode = document.selectSingleNode("/carpenterConfig/maxObjectDepth");
        String maxObjectDepthStr = maxObjectDepthNode != null ? maxObjectDepthNode.getText() : null;
        if (maxObjectDepthStr != null) {
            maxObjectDepth = Integer.parseInt(maxObjectDepthStr);
        } else {
            maxObjectDepth = 10;
        }
        Node encodingNode = document.selectSingleNode("/carpenterConfig/encoding");
        String encodingStr = encodingNode != null ? encodingNode.getText() : null;
        if (encodingStr != null) {
            encoding = encodingStr.trim().replace(" ", "");
        } else {
            encoding = DEFAULT_ENCODING;
        }
        Node collectorThreadPoolSizeNode = document.selectSingleNode("/carpenterConfig/collectorThreadPoolSize");
        String collectorThreadPoolSizeStr = collectorThreadPoolSizeNode != null ? collectorThreadPoolSizeNode.getText() : null;
        if (collectorThreadPoolSizeStr != null) {
            collectorThreadPoolSize = Integer.parseInt(collectorThreadPoolSizeStr);
        } else {
            collectorThreadPoolSize = 55;
        }
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
