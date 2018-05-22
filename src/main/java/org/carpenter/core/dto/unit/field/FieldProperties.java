package org.carpenter.core.dto.unit.field;

import java.util.List;

public class FieldProperties extends FieldBaseInfo {
    private boolean isEnum;
    private boolean isArray;
    private int modifiers;
    private int fieldTypeModifiers;
    private String genericString;
    private String declaringClass;
    private List<String> classHierarchy;
    private List<String> interfacesHierarchy;

    public FieldProperties() {
    }

    public FieldProperties(String className, String unitName) {
        super(className, unitName);
    }

    public boolean isEnum() {
        return isEnum;
    }

    public void setEnum(boolean anEnum) {
        isEnum = anEnum;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
    }

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public String getGenericString() {
        return genericString;
    }

    public void setGenericString(String genericString) {
        this.genericString = genericString;
    }

    public int getFieldTypeModifiers() {
        return fieldTypeModifiers;
    }

    public void setFieldTypeModifiers(int fieldTypeModifiers) {
        this.fieldTypeModifiers = fieldTypeModifiers;
    }

    public String getDeclaringClass() {
        return declaringClass;
    }

    public void setDeclaringClass(String declaringClass) {
        this.declaringClass = declaringClass;
    }

    public List<String> getClassHierarchy() {
        return classHierarchy;
    }

    public void setClassHierarchy(List<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public List<String> getInterfacesHierarchy() {
        return interfacesHierarchy;
    }

    public void setInterfacesHierarchy(List<String> interfacesHierarchy) {
        this.interfacesHierarchy = interfacesHierarchy;
    }
}
