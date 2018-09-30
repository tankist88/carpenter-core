package com.github.tankist88.carpenter.core.property.converter;

public class BooleanConverter implements PropConverter<Boolean> {
    @Override
    public Boolean convert(String val) {
        return Boolean.parseBoolean(val);
    }
}
