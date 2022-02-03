package com.ugamdemo.core.models.impl;

import com.ugamdemo.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TimelineImplTest {

    private final AemContext aemContext=new AemContext();

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/timeline.json", "/content");
        aemContext.addModelsForClasses(TimelineImpl.class);
    }


    @Test
    void getTimelineDetails() {
        Timeline timeline;
        aemContext.currentResource("/content");
        timeline = aemContext.request().adaptTo(Timeline.class);
        assertNull(timeline);
    }

}