package io.quarkus.hibernate.orm.panache.deployment.test;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.hibernate.orm.panache.deployment.test.inheritance.ChildEntity;

@Path("entity")
public class InheritanceResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam long id) {
        ChildEntity ret = ChildEntity.findById(id);
        if (ret == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        return ret.name;
    }
}
