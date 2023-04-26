package controller;

import model.Address;
import model.AddressSubmit;
import service.AddressService;

import javax.inject.Inject;
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
    public Response create(AddressSubmit addressSubmit) {
        addressService.persist(addressSubmit);
        return Response.status(201).build();
    }
}
