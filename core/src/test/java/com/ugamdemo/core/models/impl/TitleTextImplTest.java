package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TitleTextImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/titletext.json","/content");
    }

    @Test
    void getTitle() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("title", titleText.getTitle());
    }

    @Test
    void getText() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        assertEquals("text", titleText.getText());
    }

    @Test
    void getSectionGap() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        Boolean scetiongap = true;
        assertEquals(scetiongap, titleText.getSectionGap());
    }

    @Test
    void getBottomPadding() {
        Resource resource = aemContext.currentResource("/content");
        TitleText titleText = resource.adaptTo(TitleText.class);
        Boolean bottom = true;
        assertEquals(bottom, titleText.getBottomPadding());
    }
}