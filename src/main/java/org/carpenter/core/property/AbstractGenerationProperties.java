package org.carpenter.core.property;

public abstract class AbstractGenerationProperties implements GenerationProperties {
    static final String DEFAULT_DATA_PROVIDER_CLASS_PATTERN = "org.carpenter.CommonDataProvider_";

    public static final String TAB = " " + " " + " " + " ";
    public static final String COMMON_UTIL_POSTFIX = "GUtil";
    public static final String OBJ_FILE_EXTENSION = "tox";

    String utGenDir;
    String dataProviderClassPattern;
    String[] allowedPackagesForTests;
    String[] excludedPackagesForDp;
    String[] excludedPackagesForTraceCollect;
    String objectDumpDir;

    @Override
    public String getUtGenDir() {
        return utGenDir;
    }

    @Override
    public String getDataProviderClassPattern() {
        return dataProviderClassPattern;
    }

    @Override
    public String[] getAllowedPackagesForTests() {
        return allowedPackagesForTests;
    }

    @Override
    public String[] getExcludedPackagesForDp() {
        return excludedPackagesForDp;
    }

    @Override
    public String[] getExcludedPackagesForTraceCollect() {
        return excludedPackagesForTraceCollect;
    }

    @Override
    public String getObjectDumpDir() {
        return objectDumpDir;
    }
}
