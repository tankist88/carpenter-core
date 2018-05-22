package org.carpenter.core.property;

public interface GenerationProperties {
    /**
     * Path to directory for unit tests generation
     * @return String with path to directory for unit tests generation
     */
    String getUtGenDir();
    /**
     * Pattern for data providers class names
     * @return String with pattern for data providers class names
     */
    String getDataProviderClassPattern();
    /**
     * Array of packages which contains a classes for unit test generation
     * @return array of elements, for example: org.package.one, org.package.two.
     * Unit tests will be generated only for classes inside this packages.
     */
    String[] getAllowedPackagesForTests();
    /**
     * Array of packages to be excluded by source generator of data providers.
     * For classes in this packages source generator create method which return null.
     * @return Array of packages to be excluded by source generator of data providers.
     */
    String[] getExcludedPackagesForDp();
    /**
     * Path to directory for trace collector object dumps.
     * @return Path to directory for trace collector object dumps.
     */
    String getObjectDumpDir();
    /**
     * Arrays of packages to be excluded by object dump collector.
     * @return Arrays of packages to be excluded by object dump collector.
     */
    String[] getExcludedPackagesForTraceCollect();
}
