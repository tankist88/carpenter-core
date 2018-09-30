package com.github.tankist88.carpenter.core.property;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import static com.github.tankist88.carpenter.core.util.ConvertUtil.allowedField;
import static com.github.tankist88.object2source.util.GenerationUtil.*;

public abstract class AbstractGenerationProperties implements GenerationProperties {
    static final String DEFAULT_DATA_PROVIDER_CLASS_PATTERN = "org.carpenter.CommonDataProvider_";
    static final String DEFAULT_ENCODING = "UTF-8";
    static final int DEFAULT_MAX_OBJECT_DEPTH = 10;
    static final int DEFAULT_THREAD_POOL_SIZE = 55;


    public static final String TAB = " " + " " + " " + " ";
    public static final String COMMON_UTIL_POSTFIX = "GUtil";
    public static final String OBJ_FILE_EXTENSION = "tox";

    private String[] allowedClassesForTests;

    String utGenDir;
    String dataProviderClassPattern;
    String[] allowedPackagesForTests;
    String[] allowedPackagesForDp;
    String[] excludedPackagesForTraceCollect;
    String[] externalExtensionClassNames;
    String[] externalAssertExtensionClassNames;
    String[] excludedThreadNames;
    String objectDumpDir;
    boolean fillTestClassInstance;
    boolean noZeroArgConstructorTestAllowed;
    boolean createMockFields;
    boolean usePowermock;
    int maxObjectDepth;
    int collectorThreadPoolSize;
    String encoding;

    AbstractGenerationProperties() {
        this(null);
    }

    AbstractGenerationProperties(InputStream inputStream) {
        try {
            loadProps(inputStream);
            fillAllowedClassesForTests();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public abstract void loadProps(InputStream inputStream) throws Exception;

    private void fillAllowedClassesForTests() throws IOException, ClassNotFoundException {
        Set<String> allowedClassesForTraceCollect = new HashSet<String>();
        Set<String> allowedClassesForTestGeneration = new HashSet<String>();

        for (String p : allowedPackagesForTests) {
            for(Class<?> clazz : getClasses(p)) {
                List<String> classes = new ArrayList<String>();
                for(String cs : getClassHierarchyStr(clazz)) {
                    if (!cs.startsWith("java")) classes.add(cs);
                }
                allowedClassesForTraceCollect.addAll(classes);
                allowedClassesForTestGeneration.addAll(classes);
                for(Field f : getAllFieldsOfClass(getClassHierarchy(clazz))) {
                    Class type = f.getType().isArray() ? f.getType().getComponentType() : f.getType();
                    if(!allowedField(f)) continue;
                    if (f.getType().isArray()) {
                        allowedClassesForTraceCollect.add(type.getName());
                    } else {
                        allowedClassesForTraceCollect.addAll(getClassHierarchyStr(type));
                    }
                }
            }
        }
        allowedClassesForTests = allowedClassesForTraceCollect.toArray(new String[] {});

        allowedClassesForTestGeneration.addAll(Arrays.asList(allowedPackagesForTests));

        allowedPackagesForTests = allowedClassesForTestGeneration.toArray(new String[0]);
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }
    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class") && !file.getName().contains("$")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

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
    public String[] getAllowedPackagesForDp() {
        return allowedPackagesForDp;
    }
    @Override
    public String getObjectDumpDir() {
        return objectDumpDir;
    }
    @Override
    public String[] getExternalExtensionClassNames() {
        return externalExtensionClassNames;
    }
    @Override
    public String[] getAllowedClassesForTraceCollect() {
        return allowedClassesForTests;
    }
    @Override
    public String[] getExcludedPackagesForTraceCollect() {
        return excludedPackagesForTraceCollect;
    }
    @Override
    public String[] getExternalAssertExtensionClassNames() {
        return externalAssertExtensionClassNames;
    }
    @Override
    public String[] getExcludedThreadNames() {
        return excludedThreadNames;
    }
    @Override
    public boolean isFillTestClassInstance() {
        return fillTestClassInstance;
    }
    @Override
    public boolean isNoZeroArgConstructorTestAllowed() {
        return noZeroArgConstructorTestAllowed;
    }
    @Override
    public int getMaxObjectDepth() {
        return maxObjectDepth;
    }
    @Override
    public int getCollectorThreadPoolSize() {
        return collectorThreadPoolSize;
    }
    @Override
    public String getEncoding() {
        return encoding;
    }
    @Override
    public boolean isCreateMockFields() {
        return createMockFields;
    }
    @Override
    public boolean isUsePowermock() {
        return usePowermock;
    }
}
