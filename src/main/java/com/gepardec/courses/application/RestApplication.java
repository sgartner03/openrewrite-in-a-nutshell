package com.gepardec.courses.application;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@ApplicationPath("/v1")
@Consumes("application/json")
@Produces("application/json")
@ApplicationScoped
public class RestApplication extends Application {
}
