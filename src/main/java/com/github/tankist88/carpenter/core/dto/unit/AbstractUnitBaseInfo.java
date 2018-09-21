package com.github.tankist88.carpenter.core.dto.unit;

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
        return unitName != null ? unitName.equals(that.unitName) : that.unitName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbstractUnitBaseInfo{" +
                "unitName='" + unitName + '\'' +
                "} " + super.toString();
    }
}
