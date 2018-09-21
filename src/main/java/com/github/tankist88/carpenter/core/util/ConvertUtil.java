package com.github.tankist88.carpenter.core.util;

import com.github.tankist88.carpenter.core.dto.unit.field.FieldBaseInfo;
import com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.tankist88.object2source.util.GenerationUtil.*;
import static java.lang.reflect.Modifier.*;


public class ConvertUtil {
    public static FieldProperties toFieldProperties(Field field) {
        if (field == null) return null;
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
        return getFieldProperties(fields, new Predicate() {
            @Override
            public boolean allowed(Field f) {
                return allowedField(f);
            }
        });
    }

    public static List<FieldProperties> toNonStaticProperties(List<Field> fields) {
        return getFieldProperties(fields, new Predicate() {
            @Override
            public boolean allowed(Field f) {
                return !deniedModifier(f);
            }
        });
    }

    private static List<FieldProperties> getFieldProperties(List<Field> fields, Predicate predicate) {
        if (fields == null) return null;
        List<FieldProperties> result = new ArrayList<FieldProperties>();
        Set<FieldBaseInfo> fieldsSet = new HashSet<FieldBaseInfo>();
        for (Field f : fields) {
            FieldBaseInfo fieldBaseInfo = new FieldBaseInfo(f.getType().getName(), f.getName());
            if (predicate.allowed(f) && !fieldsSet.contains(fieldBaseInfo)) {
                fieldsSet.add(fieldBaseInfo);
                result.add(toFieldProperties(f));
            }
        }
        return result;
    }

    public static boolean allowedField(Field f) {
        String tName = f.getType().getName();
        boolean deniedType =
                isPrimitive(tName) ||
                isWrapper(tName) ||
                tName.equals(Class.class.getName()) ||
                tName.equals(String.class.getName()) ||
                tName.startsWith("java") ||
                f.getType().isArray() ||
                f.getType().isEnum();
        return !deniedModifier(f) && !deniedType;
    }

    private static boolean deniedModifier(Field f) {
        return  isStatic(f.getModifiers()) ||
                isNative(f.getModifiers()) ||
                isPrivate(f.getType().getModifiers());
    }

    private interface Predicate {
        boolean allowed(Field f);
    }
}
