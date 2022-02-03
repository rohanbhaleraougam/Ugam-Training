package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.TestimonialMulti;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialMultiImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/testimonialmulti.json","/content");
    }

    @Test
    void getTestimonialDetails() {
        Resource resource = aemContext.currentResource("/content");
        TestimonialMulti testimonialMulti = resource.adaptTo(TestimonialMulti.class);
        assertEquals("name", testimonialMulti.getTestimonialDetails().get(0).get("name"));
        assertEquals("desc", testimonialMulti.getTestimonialDetails().get(0).get("desc"));
        assertEquals("desg", testimonialMulti.getTestimonialDetails().get(0).get("desg"));
    }
}