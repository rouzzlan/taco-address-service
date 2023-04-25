package controller;

import model.Address;
import service.AddressService;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/address")
public class AddressController {
    @Inject
    AddressService addressService;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address getAddress(@PathParam("id") String id) {
        return addressService.getAddress(id);
    }
}
