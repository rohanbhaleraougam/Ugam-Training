package com.ugamdemo.core.models;


import org.apache.sling.api.resource.LoginException;

import javax.jcr.RepositoryException;

public interface ServiceUserModel {
    public String getUserNames() throws LoginException;
}
