package com.ugamdemo.core.servlets;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;


@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "ugamdemo/components/page"
)
public class ListServlet extends SlingSafeMethodsServlet {
    private static final Logger LOG = LoggerFactory.getLogger(ListServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

        final ResourceResolver resourceResolver = request.getResourceResolver();
        Page page = resourceResolver.adaptTo(PageManager.class).getPage("/content/ugamdemo/us/en");
        JSONArray pagesArray = new JSONArray();
        try {
            Iterator<Page> childPages = page.listChildren();
            while (childPages.hasNext()) {
                Page childPage = childPages.next();
                JSONObject pageObject = new JSONObject();
                pageObject.put(childPage.getTitle(), childPage.getPath().toString());
                pagesArray.put(pageObject);
            }
        }catch (JSONException exception){
            LOG.info("\n Error : ", exception.getMessage());
        }
        response.setContentType("application/json");
        response.getWriter().write(pagesArray.toString());
    }
}



