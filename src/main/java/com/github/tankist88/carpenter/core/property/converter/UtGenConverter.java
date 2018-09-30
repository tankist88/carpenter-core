package com.github.tankist88.carpenter.core.property.converter;

public class UtGenConverter implements PropConverter<String> {
    @Override
    public String convert(String val) {
        if (val.equals("tmp")) return System.getProperty("java.io.tmpdir") + "/ut_gen";
        return val;
    }
}
