package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceImplTest {

    private final AemContext aemContext=new AemContext();

    private Price price;

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/price.json", "/content");
    }

    @Test
    void getPriceType() {

        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("Econimical",price.getPriceType());
    }

    @Test
    void getPriceTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("For the individuals", price.getPriceTitle());
    }

    @Test
    void getPriceNumber() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("01", price.getPriceNumber());

    }

    @Test
    void getPriceText1() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("Secure online transfer", price.getPriceText1());
    }

    @Test
    void getPriceText2() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("Unlimited styles for interface", price.getPriceText2());
    }

    @Test
    void getPriceText3() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        Price price = json.adaptTo(Price.class);
        assertEquals("Reliable customer service", price.getPriceText3());
    }
}