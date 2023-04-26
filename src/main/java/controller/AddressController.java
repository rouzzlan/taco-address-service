package controller;

import model.Address;
import model.AddressHash;
import model.AddressSubmit;
import service.AddressService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {
    @Inject
    AddressService addressService;
    @GET
    @Path("/{hash}")
    public Optional<Address> getAddress(@PathParam("hash") String hash) {
        return addressService.getAddress(hash);
    }

    @POST
    public Response create(AddressSubmit addressSubmit) {
        AddressHash addressHash = addressService.persist(addressSubmit);
        return Response.status(201).entity(addressHash).build();
    }
}
