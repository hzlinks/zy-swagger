package com.hzlinks.swagger.rpc.config;

import com.hzlinks.swagger.rpc.http.ReferenceManager;
import io.swagger.config.Scanner;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class DubboServiceScanner implements Scanner {

    @Override
    public Set<Class<?>> classes() {
        return interfaceMapRef().keySet();
    }

    public Map<Class<?>, Object> interfaceMapRef() {
        return ReferenceManager.getInstance().getInterfaceMapRef();
    }

    @Override
    public boolean getPrettyPrint() {
        return false;
    }

    @Override
    public void setPrettyPrint(boolean shouldPrettyPrint) {
    }

}
