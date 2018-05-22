package org.carpenter.core.dto.unit.method;

import org.carpenter.core.dto.trace.TraceAnalyzeDto;

import java.util.Objects;

public class MethodCallTraceInfo extends MethodCallInfo {
    private int valueArgumentsHashCode;
    private TraceAnalyzeDto traceAnalyzeData;
    private String key;

    public int getValueArgumentsHashCode() {
        return valueArgumentsHashCode;
    }

    public void setValueArgumentsHashCode(int valueArgumentsHashCode) {
        this.valueArgumentsHashCode = valueArgumentsHashCode;
    }

    public TraceAnalyzeDto getTraceAnalyzeData() {
        return traceAnalyzeData;
    }

    public void setTraceAnalyzeData(TraceAnalyzeDto traceAnalyzeData) {
        this.traceAnalyzeData = traceAnalyzeData;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MethodCallTraceInfo that = (MethodCallTraceInfo) o;
        return Objects.equals(traceAnalyzeData, that.traceAnalyzeData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), traceAnalyzeData);
    }

    @Override
    public String toString() {
        return "MethodCallTraceInfo{" +
                "valueArgumentsHashCode=" + valueArgumentsHashCode +
                ", traceAnalyzeData=" + traceAnalyzeData +
                ", key='" + key + '\'' +
                "} " + super.toString();
    }
}
