package com.github.tankist88.carpenter.core.dto.unit;

public abstract class ClassBaseInfo implements ClassInfo {
    private String className;

    public ClassBaseInfo() {
    }

    public ClassBaseInfo(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassBaseInfo that = (ClassBaseInfo) o;
        return className != null ? className.equals(that.className) : that.className == null;
    }

    @Override
    public int hashCode() {
        return className != null ? className.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ClassBaseInfo{" +
                "className='" + className + '\'' +
                '}';
    }
}
