package dev.miguel.controller;

import dev.miguel.model.LabSeq;
import dev.miguel.service.LabSeqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
public class LabSeqController {

    @Inject
    LabSeqService labSeqService;

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response labSeqController(@PathParam("n") Integer n) {
        try {
            LabSeq result = labSeqService.labSeq(n);
            return Response.ok(result).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
