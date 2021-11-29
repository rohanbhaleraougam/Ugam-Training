package com.ugamdemo.core.models.impl;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamdemo.core.models.ServiceUserModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = ServiceUserModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceUserModelImpl implements ServiceUserModel {

    @OSGiService
    ServiceUserModel serviceUserModel;

    @Inject
    private ResourceResolverFactory resourceResolverFactory;

    @Inject
    ResourceResolver resolver;
    @Inject
    QueryBuilder queryBuilder;
    String user = " ";


    @Override
    public String getUserNames() {


        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");

              Session session = resolver.adaptTo(Session.class);
           Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {
                 try {
                    user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class) + "\n";

                } catch (RepositoryException e) {
                    e.printStackTrace();
                }
            }

        return user;
    }


}
