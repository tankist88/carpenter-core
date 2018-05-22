package org.carpenter.core.dto.unit;

import java.util.Objects;

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
        if (!(o instanceof ClassBaseInfo)) return false;
        ClassBaseInfo that = (ClassBaseInfo) o;
        return Objects.equals(getClassName(), that.getClassName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClassName());
    }

    @Override
    public String toString() {
        return "ClassBaseInfo{" +
                "className='" + className + '\'' +
                '}';
    }
}
