package com.github.tankist88.carpenter.core.dto.argument;

import com.github.tankist88.object2source.dto.ProviderResult;

import java.util.List;

public class GeneratedArgument extends AbstractArgument {
    private ProviderResult generated;
    private List<String> interfacesHierarchy;
    private String genericString;
    private boolean anonymousClass;
    private String nearestInstantAbleClass;

    public GeneratedArgument(String className, ProviderResult generated) {
        super(className);
        this.generated = generated;
    }

    public ProviderResult getGenerated() {
        return generated;
    }

    public void setGenerated(ProviderResult generated) {
        this.generated = generated;
    }

    public List<String> getInterfacesHierarchy() {
        return interfacesHierarchy;
    }

    public void setInterfacesHierarchy(List<String> interfacesHierarchy) {
        this.interfacesHierarchy = interfacesHierarchy;
    }

    public String getGenericString() {
        return genericString;
    }

    public void setGenericString(String genericString) {
        this.genericString = genericString;
    }

    public boolean isAnonymousClass() {
        return anonymousClass;
    }

    public void setAnonymousClass(boolean anonymousClass) {
        this.anonymousClass = anonymousClass;
    }

    public String getNearestInstantAbleClass() {
        return nearestInstantAbleClass;
    }

    public void setNearestInstantAbleClass(String nearestInstantAbleClass) {
        this.nearestInstantAbleClass = nearestInstantAbleClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneratedArgument that = (GeneratedArgument) o;
        return generated != null ? generated.equals(that.generated) : that.generated == null;
    }

    @Override
    public int hashCode() {
        return generated != null ? generated.hashCode() : 0;
    }
}
