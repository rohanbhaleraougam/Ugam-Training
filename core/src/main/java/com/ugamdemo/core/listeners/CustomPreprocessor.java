package com.ugamdemo.core.listeners;

import com.ugamdemo.core.services.CurrentDate;
import com.ugamdemo.core.utils.ResolverUtils;
import com.day.cq.commons.date.DateUtil;
import com.day.cq.commons.date.InvalidDateException;
import com.day.cq.replication.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Calendar;

@Component(immediate = true)
public class CustomPreprocessor implements Preprocessor {

    private static final Logger log = LoggerFactory.getLogger(CustomPreprocessor.class);

    @Reference
    CurrentDate currentDate;

    String pagePath="/content/ugamdemo/us/en/test-for-comonents/jcr:content/root/container/date_time";

     @Reference
        private ResourceResolverFactory resourceResolverFactory;
        @Override
        public void preprocess(final ReplicationAction replicationAction,
        final ReplicationOptions replicationOptions) throws ReplicationException {

            if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
                return;
            }
            String path = replicationAction.getPath();
            if(path.equals("/content/ugamdemo/us/en/test-for-comonents")){
                log.debug("path equal");
                ResourceResolver serviceResourceResolver = null;
                try {
                    log.debug("===============inside try====================");
                    serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
                    Session session = serviceResourceResolver.adaptTo(Session.class);
                    Resource resource = serviceResourceResolver.getResource(pagePath);
                    Node node = resource.adaptTo(Node.class);
                    if(node.getProperty("time") != DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())))
                    {
                        log.debug("===============inside if====================");
                        currentDate.UpdateDate(pagePath);
                    }
                    session.save();
                    session.logout();
                } catch (LoginException | RepositoryException | InvalidDateException e) {
                    e.printStackTrace();
                }
            }
            try {
                log.debug(path);
            }
            catch (Exception e) {
               log.debug(e.getMessage());
            }
        }
    }
