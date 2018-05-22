package org.carpenter.core.dto.argument;

import org.object2source.dto.ProviderResult;

import java.util.List;
import java.util.Objects;

public class GeneratedArgument extends AbstractArgument {
    private ProviderResult generated;
    private List<String> interfacesHierarchy;
    private String genericString;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneratedArgument that = (GeneratedArgument) o;
        return Objects.equals(generated, that.generated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generated);
    }
}
