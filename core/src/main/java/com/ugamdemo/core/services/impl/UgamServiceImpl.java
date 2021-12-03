package com.ugamdemo.core.services.impl;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;
import com.ugamdemo.core.services.UgamService;


@Component(service = UgamService.class, immediate = true)
@Designate(ocd = UgamServiceImpl.ServiceConfig.class)
public class UgamServiceImpl implements UgamService {
    @ObjectClassDefinition(name = "Ugamdemo OSGI Configuration",
            description = "Custom OSGI")

    public @interface ServiceConfig{
        @AttributeDefinition(
                name="Name",
                description = "Enter Name",
                type = AttributeType.STRING)
        public String serviceName() default "Enter name";


        @AttributeDefinition(
                name="Count",
                description = "Count",
                type = AttributeType.INTEGER)
        int getServiceCount() default 0;


        @AttributeDefinition(
                name = "Instance",
                description = "Select Instance",
                options = {
                        @Option(label = "Author",value = "author"),
                        @Option(label = "Publish",value = "publish"),
                        @Option(label = "Both",value = "both")
                },
                type = AttributeType.STRING)
                String getRunMode() default "both";

    }
    private String serviceName;
    private int serviceCount;
    private String runModes;
    @Activate
    protected void activate(ServiceConfig serviceConfig){
        serviceName=serviceConfig.serviceName();
        serviceCount=serviceConfig.getServiceCount();
        runModes=serviceConfig.getRunMode();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getServiceCount() {
        return serviceCount;
    }

    @Override
    public String getRunModes() {
        return runModes;
    }
}
