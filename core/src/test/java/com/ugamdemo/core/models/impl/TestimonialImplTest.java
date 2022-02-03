package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Testimonial;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/testimonial.json","/content");
    }

    @Test
    void getTestimonialName() {
        Resource resource = aemContext.currentResource("/content");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("name", testimonial.getTestimonialName());
    }

    @Test
    void getTestimonialDescription() {
        Resource resource = aemContext.currentResource("/content");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("desc", testimonial.getTestimonialDescription());
    }

    @Test
    void getTestimonialDesignation() {
        Resource resource = aemContext.currentResource("/content");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("desg", testimonial.getTestimonialDesignation());
    }
    @Test
    void getTestimonialImage() {
        Resource resource = aemContext.currentResource("/content");
        Testimonial testimonial = resource.adaptTo(Testimonial.class);
        assertEquals("img", testimonial.getTestimonialImage());
    }

}