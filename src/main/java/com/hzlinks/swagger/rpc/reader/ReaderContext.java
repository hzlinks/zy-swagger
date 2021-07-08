package com.hzlinks.swagger.rpc.reader;

import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import java.util.List;

/**
 * The <code>ReaderContext</code> class is wrapper for the <code>Reader</code> parameters.
 */
public class ReaderContext {

    private Swagger swagger;
    private Class<?> refCls;
    private Class<?> interfaceCls;
    private String parentPath;
    private String parentHttpMethod;
    private boolean readHidden;
    private List<String> parentConsumes;
    private List<String> parentProduces;
    private List<String> parentTags;
    private List<Parameter> parentParameters;

    public ReaderContext(Swagger swagger, Class<?> refCls, Class<?> interfaceCls, String parentPath,
            String parentHttpMethod, boolean readHidden, List<String> parentConsumes,
            List<String> parentProduces, List<String> parentTags,
            List<Parameter> parentParameters) {
        setSwagger(swagger);
        setRefCls(refCls);
        setInterfaceCls(interfaceCls);
        setParentPath(parentPath);
        setParentHttpMethod(parentHttpMethod);
        setReadHidden(readHidden);
        setParentConsumes(parentConsumes);
        setParentProduces(parentProduces);
        setParentTags(parentTags);
        setParentParameters(parentParameters);
    }

    public Swagger getSwagger() {
        return swagger;
    }

    public void setSwagger(Swagger swagger) {
        this.swagger = swagger;
    }

    public Class<?> getRefCls() {
        return refCls;
    }

    public void setRefCls(Class<?> cls) {
        this.refCls = cls;
    }

    public Class<?> getInterfaceCls() {
        return interfaceCls;
    }

    public Class<?> getCls() {
        return refCls;
    }

    public void setInterfaceCls(Class<?> interfaceCls) {
        this.interfaceCls = interfaceCls;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getParentHttpMethod() {
        return parentHttpMethod;
    }

    public void setParentHttpMethod(String parentHttpMethod) {
        this.parentHttpMethod = parentHttpMethod;
    }

    public boolean isReadHidden() {
        return readHidden;
    }

    public void setReadHidden(boolean readHidden) {
        this.readHidden = readHidden;
    }

    public List<String> getParentConsumes() {
        return parentConsumes;
    }

    public void setParentConsumes(List<String> parentConsumes) {
        this.parentConsumes = parentConsumes;
    }

    public List<String> getParentProduces() {
        return parentProduces;
    }

    public void setParentProduces(List<String> parentProduces) {
        this.parentProduces = parentProduces;
    }

    public List<String> getParentTags() {
        return parentTags;
    }

    public void setParentTags(List<String> parentTags) {
        this.parentTags = parentTags;
    }

    public List<Parameter> getParentParameters() {
        return parentParameters;
    }

    public void setParentParameters(List<Parameter> parentParameters) {
        this.parentParameters = parentParameters;
    }


}
