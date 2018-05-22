package org.carpenter.core.dto.trace;

import java.io.Serializable;
import java.util.Objects;

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
        return Objects.equals(upLevelElementKey, that.upLevelElementKey) &&
                Objects.equals(upLevelElementClassName, that.upLevelElementClassName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(upLevelElementKey, upLevelElementClassName);
    }

    @Override
    public String toString() {
        return "TraceAnalyzeDto{" +
                "upLevelElementKey='" + upLevelElementKey + '\'' +
                ", upLevelElementClassName='" + upLevelElementClassName + '\'' +
                '}';
    }
}
