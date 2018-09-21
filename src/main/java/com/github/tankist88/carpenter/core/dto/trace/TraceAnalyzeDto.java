package com.github.tankist88.carpenter.core.dto.trace;

import java.io.Serializable;

public class TraceAnalyzeDto implements Serializable {
    /** Caller method key */
    private String upLevelElementKey;
    /** Caller class name */
    private String upLevelElementClassName;

    public String getUpLevelElementKey() {
        return upLevelElementKey;
    }

    public void setUpLevelElementKey(String upLevelElementKey) {
        this.upLevelElementKey = upLevelElementKey;
    }

    public String getUpLevelElementClassName() {
        return upLevelElementClassName;
    }

    public void setUpLevelElementClassName(String upLevelElementClassName) {
        this.upLevelElementClassName = upLevelElementClassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraceAnalyzeDto that = (TraceAnalyzeDto) o;
        if (upLevelElementKey != null ? !upLevelElementKey.equals(that.upLevelElementKey) : that.upLevelElementKey != null)
            return false;
        return upLevelElementClassName != null ? upLevelElementClassName.equals(that.upLevelElementClassName) : that.upLevelElementClassName == null;
    }

    @Override
    public int hashCode() {
        int result = upLevelElementKey != null ? upLevelElementKey.hashCode() : 0;
        result = 31 * result + (upLevelElementClassName != null ? upLevelElementClassName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TraceAnalyzeDto{" +
                "upLevelElementKey='" + upLevelElementKey + '\'' +
                ", upLevelElementClassName='" + upLevelElementClassName + '\'' +
                '}';
    }
}
