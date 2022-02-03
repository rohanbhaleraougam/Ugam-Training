package com.ugamdemo.core.services.impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamdemo.core.services.ServiceUser;
import com.ugamdemo.core.utils.ResolverUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceUserImpl implements ServiceUser {
    @SlingObject
    ResourceResolver resourceResolver;
    @OSGiService
    ResourceResolverFactory resourceResolverFactory;
    @Inject
    private QueryBuilder queryBuilder;

    @Override
    public List<String> getUsernames(){

        final Logger LOG = LoggerFactory.getLogger(ServiceUserImpl.class);
        List<String> usernames = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try (ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)) {
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {
                Resource hitResults = hit.getResource();
                usernames.add(hitResults.getName());
            }
        } catch (RepositoryException e) {
            LOG.error(e.getMessage());
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return  usernames;
    }

}