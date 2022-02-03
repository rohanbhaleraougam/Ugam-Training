package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Facts;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactsImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/factarea.json","/content");
    }

    @Test
    void getFactsDetails() {
        Resource resource = aemContext.currentResource("/content/factarea");
        Facts Facts = resource.adaptTo(Facts.class);
        assertEquals("2536", Facts.getFactAreaDetails().get(0).get("factNumber"));
    }
}