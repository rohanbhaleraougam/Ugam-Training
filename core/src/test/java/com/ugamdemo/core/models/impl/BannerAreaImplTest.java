package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.BannerArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerAreaImplTest {

    private final AemContext aemContext = new AemContext();
    private BannerArea bannerArea;

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/bannerArea.json", "/content");
    }

    @Test
    void getBannerAreaTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("THIS IS ME", bannerArea.getBannerAreaTitle());
    }

    @Test
    void getBannerAreaHeading() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("PHILIP GILBERT", bannerArea.getBannerAreaHeading());
    }

    @Test
    void getBannerAreaDescription() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.\r\n", bannerArea.getBannerAreaDescription());
    }

    @Test
    void getBannerAreaButtonTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("VIEW FULL DETAILS", bannerArea.getBannerAreaButtonTitle());
    }

    @Test
    void getImg() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("/content/dam/ugamdemo/hero-img.png", bannerArea.getImg());
    }

    @Test
    void getPathValue() {
        Resource json = aemContext.resourceResolver().getResource("/content");
        BannerArea bannerArea = json.adaptTo(BannerArea.class);
        assertEquals("/content/ugamdemo/us/en/home", bannerArea.getPathValue());
    }
}