package com.github.tankist88.carpenter.core.dto.unit;

import java.util.Objects;

public abstract class AbstractUnitBaseInfo extends ClassBaseInfo implements ClassInfo {
    private String unitName;

    public AbstractUnitBaseInfo() {
    }

    protected AbstractUnitBaseInfo(String className, String unitName) {
        super(className);
        this.unitName = unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractUnitBaseInfo that = (AbstractUnitBaseInfo) o;
        return Objects.equals(unitName, that.unitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unitName);
    }

    @Override
    public String toString() {
        return "AbstractUnitBaseInfo{" +
                "unitName='" + unitName + '\'' +
                "} " + super.toString();
    }
}
