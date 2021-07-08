package com.hzlinks.swagger.rpc.reader;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.PrioritizedParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

public final class NameDiscover {

    public static final ParameterNameDiscoverer parameterNameDiscover;

    static {
        parameterNameDiscover = new PrioritizedParameterNameDiscoverer();
        ((PrioritizedParameterNameDiscoverer) parameterNameDiscover)
                .addDiscoverer(new LocalVariableTableParameterNameDiscoverer());
        ((PrioritizedParameterNameDiscoverer) parameterNameDiscover)
                .addDiscoverer(new StandardReflectionParameterNameDiscoverer());
    }

}
