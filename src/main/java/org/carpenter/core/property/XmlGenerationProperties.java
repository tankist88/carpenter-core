package org.carpenter.core.property;

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
        this.utGenDir = utGenDirNode != null ? utGenDirNode.getText() : null;
        if (StringUtils.isBlank(this.utGenDir) || this.utGenDir.equals("tmp")) {
            this.utGenDir = System.getProperty("java.io.tmpdir") + "/ut_gen";
        }
        Node dpcNode = document.selectSingleNode("/carpenterConfig/dataProviderClassPattern");
        this.dataProviderClassPattern = dpcNode != null ? dpcNode.getText() : null;
        if (StringUtils.isBlank(this.dataProviderClassPattern)) {
            this.dataProviderClassPattern = DEFAULT_DATA_PROVIDER_CLASS_PATTERN;
        }
        allowedPackagesForTests = getArrayProperty(document, "allowedPackagesForTests");
        allowedPackagesForDp = getArrayProperty(document, "allowedPackagesForDp");
        excludedPackagesForTraceCollect = getArrayProperty(document, "excludedPackagesForTraceCollect");
        externalExtensionClassNames = getArrayProperty(document, "externalExtensionClassNames");
        externalAssertExtensionClassNames = getArrayProperty(document, "externalAssertExtensionClassNames");
        excludedThreadNames = getArrayProperty(document, "excludedThreadNames");
        Node objectDumpDirNode = document.selectSingleNode("/carpenterConfig/objectDumpDir");
        this.objectDumpDir = objectDumpDirNode != null ? objectDumpDirNode.getText() : null;
        if (this.objectDumpDir == null || this.objectDumpDir.equals("tmp")) {
            this.objectDumpDir = System.getProperty("java.io.tmpdir") + "/trace_dump";
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
