package com.ugamdemo.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class, AemContextExtension.class})
class AdditionServletTest {
    private AdditionServlet additionServlet = new AdditionServlet();

    @BeforeEach
    void setUp() throws Exception{

    }

    @Test
    void doGet(AemContext context) throws ServletException, IOException{
        MockSlingHttpServletRequest request = context.request();
        MockSlingHttpServletResponse response = context.response();
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("num1", 4);
        parameters.put("num2", 4);
        request.setParameterMap(parameters);
        additionServlet.doGet(request, response);
        assertEquals(8, Integer.parseInt(response.getOutputAsString()));
    }

}