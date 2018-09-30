package com.github.tankist88.carpenter.core.util;

import com.github.tankist88.carpenter.core.property.converter.BooleanConverter;
import com.github.tankist88.carpenter.core.property.converter.IntegerConverter;
import com.github.tankist88.carpenter.core.property.converter.PropConverter;
import com.github.tankist88.carpenter.core.property.converter.StringConverter;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.Properties;

public class PropertyUtils {

    public static Boolean getBooleanProperty(Document document, String propName, Boolean defaultValue) {
        return getSingleProperty(document, propName, defaultValue, new BooleanConverter());
    }

    public static Boolean getBooleanProperty(Properties prop, String propName, Boolean defaultValue) {
        return getSingleProperty(prop, propName, defaultValue, new BooleanConverter());
    }

    public static Integer getIntegerProperty(Document document, String propName, Integer defaultValue) {
        return getSingleProperty(document, propName, defaultValue, new IntegerConverter());
    }

    public static Integer getIntegerProperty(Properties prop, String propName, Integer defaultValue) {
        return getSingleProperty(prop, propName, defaultValue, new IntegerConverter());
    }

    public static String getStringProperty(Document document, String propName, String defaultValue) {
        return getSingleProperty(document, propName, defaultValue, new StringConverter());
    }

    public static String getStringProperty(Properties prop, String propName, String defaultValue) {
        return getSingleProperty(prop, propName, defaultValue, new StringConverter());
    }

    public static <T> T getSingleProperty(Document document, String propName, T defaultValue, PropConverter<T> conv) {
        Node node = document.selectSingleNode("/carpenterConfig/" + propName);
        String valueStr = node != null ? node.getText() : null;
        return getSingleProperty(valueStr, defaultValue, conv);
    }

    public static <T> T getSingleProperty(Properties prop, String propName, T defaultValue, PropConverter<T> conv) {
        String valueStr = (String) prop.get(propName);
        return getSingleProperty(valueStr, defaultValue, conv);
    }

    private static <T> T getSingleProperty(String valueStr, T defaultValue, PropConverter<T> conv) {
        if (StringUtils.isNotBlank(valueStr) && conv != null) {
            return conv.convert(valueStr);
        } else {
            return defaultValue;
        }
    }
}
