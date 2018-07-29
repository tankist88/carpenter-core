package com.github.tankist88.carpenter.core.util;

import com.github.tankist88.carpenter.core.dto.unit.field.FieldBaseInfo;
import com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.tankist88.object2source.util.GenerationUtil.*;


public class ConvertUtil {
    public static FieldProperties toFieldProperties(Field field) {
        if(field == null) return null;
        FieldProperties result = new FieldProperties();
        result.setClassName(field.getType().getName());
        result.setUnitName(field.getName());
        result.setArray(field.getType().isArray());
        result.setEnum(field.getType().isEnum());
        result.setModifiers(field.getModifiers());
        result.setFieldTypeModifiers(field.getType().getModifiers());
        result.setGenericString(TypeHelper.getFieldGenericTypeStr(field));
        result.setDeclaringClass(field.getDeclaringClass().getName());
        result.setClassHierarchy(getClassHierarchyStr(field.getType()));
        result.setInterfacesHierarchy(getInterfacesHierarchyStr(field.getType()));
        return result;
    }

    public static List<FieldProperties> toServiceProperties(List<Field> fields) {
        if(fields == null) return null;
        List<FieldProperties> result = new ArrayList<>();
        Set<FieldBaseInfo> serviceClasses = new HashSet<>();
        for(Field f : fields) {
            FieldBaseInfo fieldBaseInfo = new FieldBaseInfo(f.getType().getName(), f.getName());
            if (allowedField(f) && !serviceClasses.contains(fieldBaseInfo)) {
                serviceClasses.add(fieldBaseInfo);
                result.add(toFieldProperties(f));
            }
        }
        return result;
    }

    public static boolean allowedField(Field f) {
        boolean deniedModifier =
                Modifier.isStatic(f.getModifiers()) ||
                Modifier.isNative(f.getModifiers()) ||
                Modifier.isPrivate(f.getType().getModifiers());
        boolean deniedType =
                isPrimitive(f.getType().getName()) ||
                isWrapper(f.getType().getName()) ||
                f.getType().getName().equals(Class.class.getName()) ||
                f.getType().getName().equals(String.class.getName()) ||
                f.getType().getName().startsWith("java") ||
                f.getType().isArray() ||
                f.getType().isEnum();
        return !deniedModifier && !deniedType;
    }
}
