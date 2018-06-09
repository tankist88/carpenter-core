package org.carpenter.core.property;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;

import static org.carpenter.core.util.ConvertUtil.allowedField;
import static org.object2source.util.GenerationUtil.*;

public abstract class AbstractGenerationProperties implements GenerationProperties {
    static final String DEFAULT_DATA_PROVIDER_CLASS_PATTERN = "org.carpenter.CommonDataProvider_";

    public static final String TAB = " " + " " + " " + " ";
    public static final String COMMON_UTIL_POSTFIX = "GUtil";
    public static final String OBJ_FILE_EXTENSION = "tox";

    private String[] allowedClassesForTests;

    String utGenDir;
    String dataProviderClassPattern;
    String[] allowedPackagesForTests;
    String[] excludedPackagesForDp;
    String[] excludedPackagesForTraceCollect;
    String[] externalExtensionClassNames;
    String objectDumpDir;

    AbstractGenerationProperties() {
        loadProps();
        try {
            fillAllowedClassesForTests();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public abstract void loadProps();

    private void fillAllowedClassesForTests() throws IOException, ClassNotFoundException {
        Set<String> allowedClassesForTraceCollect = new HashSet<>();
        Set<String> allowedClassesForTestGeneration = new HashSet<>();

        for (String p : allowedPackagesForTests) {
            for(Class<?> clazz : getClasses(p)) {
                List<String> classes = new ArrayList<>();
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
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
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
        List<Class> classes = new ArrayList<>();
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
    public String[] getExcludedPackagesForDp() {
        return excludedPackagesForDp;
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
}
