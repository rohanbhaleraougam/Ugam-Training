package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Services;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ServicesImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/services.json","/content");
    }

    @Test
    void getServiceTitle() {
        Resource resource = aemContext.currentResource("/content");
        Services services = resource.adaptTo(Services.class);
        assertEquals("title", services.getServiceTitle());
    }

    @Test
    void getServiceText() {
        Resource resource = aemContext.currentResource("/content");
        Services services = resource.adaptTo(Services.class);
        assertEquals("text", services.getServiceText());
    }
}