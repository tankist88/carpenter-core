package com.github.tankist88.carpenter.core.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static com.github.tankist88.object2source.util.GenerationUtil.getMethodArgGenericTypes;
import static com.github.tankist88.object2source.util.GenerationUtil.getParameterizedTypes;

public class TypeHelper {
    private static String clearClassName(String className) {
        return className.replaceAll("\\$", ".");
    }

    public static String getMethodArgGenericTypeStr(List<Class> classHierarchy, String methodName, int argNum, Class<?>... args) throws NoSuchMethodException {
        return classListAsString(getMethodArgGenericTypes(classHierarchy, methodName, argNum, args));
    }

    public static String getFieldGenericTypeStr(Field field) {
        return classListAsString(getParameterizedTypes(field.getGenericType()));
    }

    private static String classListAsString(List<Class> genericTypes) {
        if(genericTypes.size() > 0) {
            StringBuilder gTypeNameBuilder = new StringBuilder();
            Iterator iterator = genericTypes.iterator();
            while (iterator.hasNext()) {
                gTypeNameBuilder.append(clearClassName(((Class) iterator.next()).getName()));
                if(iterator.hasNext()) gTypeNameBuilder.append(", ");
            }
            return gTypeNameBuilder.toString();
        }
        return null;
    }
}
