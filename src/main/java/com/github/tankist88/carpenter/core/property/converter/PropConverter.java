package com.github.tankist88.carpenter.core.property.converter;

public interface PropConverter<T> {
    T convert(String val);
}
