package org.carpenter.core.util;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static org.object2source.util.GenerationUtil.getMethodArgGenericTypes;
import static org.object2source.util.GenerationUtil.getParameterizedTypes;

public class TypeHelper {
    private static String clearClassName(String className) {
        return className.replaceAll("\\$", ".");
    }

    public static String getMethodArgGenericTypeStr(List<Class> classHierarchy, String methodName, int argNum, Class<?>... args) throws NoSuchMethodException {
        return classListAsString(getMethodArgGenericTypes(classHierarchy, methodName, argNum, args), true);
    }

    public static String getFieldGenericTypeStr(Field field) {
        return classListAsString(getParameterizedTypes(field.getGenericType()), false);
    }

    private static String classListAsString(List<Class> genericTypes, boolean useObjectForEmpty) {
        StringBuilder gTypeNameBuilder = new StringBuilder();
        if(genericTypes.size() > 0) {
            Iterator iterator = genericTypes.iterator();
            while (iterator.hasNext()) {
                gTypeNameBuilder.append(clearClassName(((Class) iterator.next()).getName()));
                if(iterator.hasNext()) gTypeNameBuilder.append(", ");
            }
        } else if(useObjectForEmpty) {
            gTypeNameBuilder.append(Object.class.getName());
        }
        return gTypeNameBuilder.toString();
    }
}
