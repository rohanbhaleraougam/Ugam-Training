package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Portfolio;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PortfolioImplTest {

    private final AemContext aemContext = new AemContext();

    @BeforeEach
    void setUp() {
        aemContext.load().json("/portfolio.json","/content");
    }

    @Test
    void getPortfolioTitle() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("portfolioText", portfolio.getPortfolioTitle());
    }

    @Test
    void getPortfolioText() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("portfolioTitle", portfolio.getPortfolioText());
    }

    @Test
    void getImg() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("img", portfolio.getImg());
    }

    @Test
    void getPreimg() {
        Resource resource = aemContext.currentResource("/content");
        Portfolio portfolio = resource.adaptTo(Portfolio.class);
        assertEquals("preimg", portfolio.getPreimg());
    }
}