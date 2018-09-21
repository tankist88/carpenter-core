package com.github.tankist88.carpenter.core.dto.unit.method;

import com.github.tankist88.carpenter.core.dto.trace.TraceAnalyzeDto;

public class MethodCallTraceInfo extends MethodCallInfo {
    private TraceAnalyzeDto traceAnalyzeData;
    private String key;

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
        return traceAnalyzeData != null ? traceAnalyzeData.equals(that.traceAnalyzeData) : that.traceAnalyzeData == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (traceAnalyzeData != null ? traceAnalyzeData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MethodCallTraceInfo{" +
                "traceAnalyzeData=" + traceAnalyzeData +
                ", key='" + key + '\'' +
                "} " + super.toString();
    }
}
