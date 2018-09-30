package com.github.tankist88.carpenter.core.property.converter;

public class IntegerConverter implements PropConverter<Integer> {
    @Override
    public Integer convert(String val) {
        return Integer.parseInt(val);
    }
}
