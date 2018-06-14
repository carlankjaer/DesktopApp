package rest.implementations;

import rest.DTO.JWT;
import rest.DTO.LoginDetails;
import rest.DTO.Role;
import rest.interfaces.AuthenticationClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by magnus
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationClientImpl implements AuthenticationClient{
    private static final String servicePath = "authentication";

    @Override
    public String login(LoginDetails loginDetails) {
        Client client = ClientBuilder.newBuilder().register(LoginDetails.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath+"/login");
        Response response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(loginDetails, MediaType.APPLICATION_JSON));
        return response.readEntity(String.class);
    }

    @Override
    public Role getRole() {
        Client client = ClientBuilder.newBuilder().register(Role.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath+"/role");
        Response response = target.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(Role.class);
    }
}
