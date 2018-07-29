package com.github.tankist88.carpenter.core.dto.unit;

import java.io.Serializable;

/**
 * This interface represents base properties for class members.
 * Method, Field, Import
 */
public interface ClassInfo extends Serializable {
    /**
     * Full class name
     * @return full class name
     */
    String getClassName();

    /**
     * Unit name. It will be a method name, field name or import statement
     * @return unit name
     */
    String getUnitName();
}
