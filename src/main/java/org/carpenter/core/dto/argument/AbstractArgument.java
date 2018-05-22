package org.carpenter.core.dto.argument;

import java.io.Serializable;

public abstract class AbstractArgument implements Serializable {
    private String className;

    public AbstractArgument(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
