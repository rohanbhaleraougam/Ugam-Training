package com.ugamdemo.core.schedulers;

import com.ugamdemo.core.config.SchedulerConfiguration;
import com.ugamdemo.core.services.SchedularService;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = SchedulerConfiguration.class)

public class UgamsProjScheduler implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(UgamsProjScheduler.class);

    private int schedulerId;
    @Reference
    private SchedularService schedularService;

    @Reference
    private Scheduler scheduler;

    @OSGiService
    ResourceResolverFactory resourceResolverFactory;


    String compPath="/content/ugamdemo/us/en/test-for-comonents/jcr:content/root/container/date_time";


    @Activate
    protected void activate(SchedulerConfiguration config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(SchedulerConfiguration config) {
        removeScheduler();
    }

    private void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfiguration config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\n <---------Scheduler added---------->");
    }
    @Override
    public void run() {

        schedularService.getServiceName(compPath);
        LOG.info("\n<-----------Inside Run Method----------->");
    }

}

