package controller;

import model.Address;
import service.AddressService;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {
    @Inject
    AddressService addressService;
    @GET
    @Path("/{id}")
    public Address getAddress(@PathParam("id") String id) {
        return addressService.getAddress(id);
    }

    @POST
    public Response create(Address address) {
        addressService.persist(address);
        return Response.status(201).build();
    }
}
