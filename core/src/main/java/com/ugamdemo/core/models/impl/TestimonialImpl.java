package com.ugamdemo.core.models.impl;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.ugamdemo.core.models.Testimonial;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Testimonial.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json")

public class TestimonialImpl implements Testimonial{

    static final String RESOURCE_TYPE = "ugamdemo/components/content/testimonial";

    @Inject
    String name;

    @Inject
    String img;

    @Inject
    String desc;

    @Inject
    String desg;


    @Override
    public String getTestimonialName() {
        return name;
    }

    @Override
    public String getTestimonialDescription() {
        return desc;
    }

    @Override
    public String getTestimonialDesignation() {
        return desg;
    }

    @Override
    public String getTestimonialImage(){
        return img;
    }

    @JsonProperty(value = "Sample Test")
    public String Testimonialsampletext(){return "Sample Text for custom exporter";}
}
