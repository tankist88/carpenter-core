package com.github.tankist88.carpenter.core.dto.unit.method;

import com.github.tankist88.carpenter.core.dto.argument.GeneratedArgument;
import com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MethodCallInfo extends MethodBaseInfo {
    //common attributes
    private long callTime;

    // class attributes
    private String declaringTypeName;
    private int classModifiers;
    private List<String> classHierarchy;
    private List<String> interfacesHierarchy;
    private List<FieldProperties> serviceFields;
    private boolean classHasZeroArgConstructor;

    // method attributes
    private int methodModifiers;
    private boolean isVoidMethod;
    private boolean isMemberClass;
    private List<GeneratedArgument> arguments;
    private GeneratedArgument returnArg;
    private Set<MethodCallInfo> innerMethods;

    public String getDeclaringTypeName() {
        return declaringTypeName;
    }

    public void setDeclaringTypeName(String declaringTypeName) {
        this.declaringTypeName = declaringTypeName;
    }

    public int getMethodModifiers() {
        return methodModifiers;
    }

    public void setMethodModifiers(int methodModifiers) {
        this.methodModifiers = methodModifiers;
    }

    public boolean isMemberClass() {
        return isMemberClass;
    }

    public void setMemberClass(boolean memberClass) {
        isMemberClass = memberClass;
    }

    public int getClassModifiers() {
        return classModifiers;
    }

    public void setClassModifiers(int classModifiers) {
        this.classModifiers = classModifiers;
    }

    public boolean isVoidMethod() {
        return isVoidMethod;
    }

    public void setVoidMethod(boolean voidMethod) {
        isVoidMethod = voidMethod;
    }

    public List<GeneratedArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<GeneratedArgument> arguments) {
        this.arguments = arguments;
    }

    public GeneratedArgument getReturnArg() {
        return returnArg;
    }

    public void setReturnArg(GeneratedArgument returnArg) {
        this.returnArg = returnArg;
    }

    public Set<MethodCallInfo> getInnerMethods() {
        if(innerMethods == null) {
            innerMethods = new HashSet<>();
        }
        return innerMethods;
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

    public List<FieldProperties> getServiceFields() {
        return serviceFields;
    }

    public void setServiceFields(List<FieldProperties> serviceFields) {
        this.serviceFields = serviceFields;
    }

    public void setInnerMethods(Set<MethodCallInfo> innerMethods) {
        this.innerMethods = innerMethods;
    }

    public long getCallTime() {
        return callTime;
    }

    public void setCallTime(long callTime) {
        this.callTime = callTime;
    }

    public boolean isClassHasZeroArgConstructor() {
        return classHasZeroArgConstructor;
    }

    public void setClassHasZeroArgConstructor(boolean classHasZeroArgConstructor) {
        this.classHasZeroArgConstructor = classHasZeroArgConstructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MethodCallInfo)) return false;
        if (!super.equals(o)) return false;
        MethodCallInfo that = (MethodCallInfo) o;
        return getMethodModifiers() == that.getMethodModifiers() &&
                getClassModifiers() == that.getClassModifiers() &&
                isVoidMethod() == that.isVoidMethod() &&
                isMemberClass() == that.isMemberClass() &&
                Objects.equals(getDeclaringTypeName(), that.getDeclaringTypeName()) &&
                Objects.equals(getArguments(), that.getArguments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDeclaringTypeName(), getMethodModifiers(), getClassModifiers(), isVoidMethod(), isMemberClass(), getArguments());
    }

    @Override
    public String toString() {
        return "MethodCallInfo{" +
                "callTime=" + callTime +
                ", declaringTypeName='" + declaringTypeName + '\'' +
                ", classModifiers=" + classModifiers +
                ", classHierarchy=" + classHierarchy +
                ", interfacesHierarchy=" + interfacesHierarchy +
                ", serviceFields=" + serviceFields +
                ", classHasZeroArgConstructor=" + classHasZeroArgConstructor +
                ", methodModifiers=" + methodModifiers +
                ", isVoidMethod=" + isVoidMethod +
                ", isMemberClass=" + isMemberClass +
                ", arguments=" + arguments +
                ", returnArg=" + returnArg +
                ", innerMethods=" + innerMethods +
                "} " + super.toString();
    }
}
