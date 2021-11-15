package com.ugamdemo.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ugamdemo.core.models.Timeline;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Model(adaptables = Resource.class,
        adapters = Timeline.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions="json")

public class TimelineImpl implements Timeline {

    static final String RESOURCE_TYPE ="ugamdemo/components/content/timeline";

    @ChildResource
    Resource timeline;
    @Override
    @JsonProperty(value = "Timeline Details For Various Time")
    public List<Map<String, String>> getTimelineDetails() {
        List<Map<String, String>> timelineMap = new ArrayList<>();
        if (timeline != null) {
            for (Resource fact : timeline.getChildren()) {
                Map<String, String> tMap = new HashMap<>();
                tMap.put("title", fact.getValueMap().get("title", String.class));
                tMap.put("text1", fact.getValueMap().get("text1", String.class));
                tMap.put("text2", fact.getValueMap().get("text2", String.class));
                timelineMap.add(tMap);
            }
        }
        return timelineMap;
    }
    @JsonProperty(value = "Sample Test")
    public String Timelinesampletext(){return "Sample Text for custom exporter";}
}