package com.github.tankist88.carpenter.core.dto.unit.method;

import com.github.tankist88.carpenter.core.dto.argument.GeneratedArgument;
import com.github.tankist88.carpenter.core.dto.unit.field.FieldProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MethodCallInfo extends MethodBaseInfo {
    //common attributes
    private long startTime;
    private long endTime;

    // class attributes
    private String declaringTypeName;
    private int classModifiers;
    private List<String> classHierarchy;
    private List<String> interfacesHierarchy;
    private List<FieldProperties> serviceFields;
    private boolean maybeServiceClass;
    private boolean dtoClass;
    private boolean classHasZeroArgConstructor;
    private String nearestInstantAbleClass;
    private String genericString;
    private boolean isMemberClass;
    private int classHashCode;

    // method attributes
    private int methodModifiers;
    private boolean isVoidMethod;
    private List<GeneratedArgument> arguments;
    private GeneratedArgument returnArg;
    private Set<MethodCallInfo> innerMethods;
    private GeneratedArgument targetObj;

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
            innerMethods = new HashSet<MethodCallInfo>();
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

    public boolean isMaybeServiceClass() {
        return maybeServiceClass;
    }

    public void setMaybeServiceClass(boolean maybeServiceClass) {
        this.maybeServiceClass = maybeServiceClass;
    }

    public boolean isDtoClass() {
        return dtoClass;
    }

    public void setDtoClass(boolean dtoClass) {
        this.dtoClass = dtoClass;
    }

    public void setInnerMethods(Set<MethodCallInfo> innerMethods) {
        this.innerMethods = innerMethods;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isClassHasZeroArgConstructor() {
        return classHasZeroArgConstructor;
    }

    public void setClassHasZeroArgConstructor(boolean classHasZeroArgConstructor) {
        this.classHasZeroArgConstructor = classHasZeroArgConstructor;
    }

    public String getNearestInstantAbleClass() {
        return nearestInstantAbleClass;
    }

    public void setNearestInstantAbleClass(String nearestInstantAbleClass) {
        this.nearestInstantAbleClass = nearestInstantAbleClass;
    }

    public GeneratedArgument getTargetObj() {
        return targetObj;
    }

    public void setTargetObj(GeneratedArgument targetObj) {
        this.targetObj = targetObj;
    }

    public String getGenericString() {
        return genericString;
    }

    public void setGenericString(String genericString) {
        this.genericString = genericString;
    }

    public int getClassHashCode() {
        return classHashCode;
    }

    public void setClassHashCode(int classHashCode) {
        this.classHashCode = classHashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MethodCallInfo that = (MethodCallInfo) o;
        if (classModifiers != that.classModifiers) return false;
        if (methodModifiers != that.methodModifiers) return false;
        if (isVoidMethod != that.isVoidMethod) return false;
        if (isMemberClass != that.isMemberClass) return false;
        if (declaringTypeName != null ? !declaringTypeName.equals(that.declaringTypeName) : that.declaringTypeName != null)
            return false;
        return arguments != null ? arguments.equals(that.arguments) : that.arguments == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (declaringTypeName != null ? declaringTypeName.hashCode() : 0);
        result = 31 * result + classModifiers;
        result = 31 * result + methodModifiers;
        result = 31 * result + (isVoidMethod ? 1 : 0);
        result = 31 * result + (isMemberClass ? 1 : 0);
        result = 31 * result + (arguments != null ? arguments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " MethodCallInfo{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", declaringTypeName='" + declaringTypeName + '\'' +
                ", classModifiers=" + classModifiers +
                ", classHierarchy=" + classHierarchy +
                ", interfacesHierarchy=" + interfacesHierarchy +
                ", serviceFields=" + serviceFields +
                ", maybeServiceClass=" + maybeServiceClass +
                ", dtoClass=" + dtoClass +
                ", classHasZeroArgConstructor=" + classHasZeroArgConstructor +
                ", nearestInstantAbleClass='" + nearestInstantAbleClass + '\'' +
                ", genericString='" + genericString + '\'' +
                ", isMemberClass=" + isMemberClass +
                ", classHashCode=" + classHashCode +
                ", methodModifiers=" + methodModifiers +
                ", isVoidMethod=" + isVoidMethod +
                ", arguments=" + arguments +
                ", returnArg=" + returnArg +
                ", innerMethods=" + innerMethods +
                ", targetObj=" + targetObj +
                '}';
    }
}
