package rest.implementations;

import rest.DTO.Account;
import rest.DTO.JWT;
import rest.interfaces.AccountClient;

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
public class AccountClientImpl implements AccountClient {
    private String servicePath = "customer/account";
    @Override
    public Account getAccountForUser(int userid) {
        Client client = ClientBuilder.newClient();
        Account element = client.target(DefaultClientImpl.restService)
                .path(servicePath)
                .path(""+userid)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .get(Account.class);
        return element;
    }

    @Override
    public Account withdraw(int userid, int amount) {
        Client client = ClientBuilder.newBuilder().register(Integer.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath)
                .path(""+userid);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(amount, MediaType.APPLICATION_JSON));
        return response.readEntity(Account.class);
    }

    @Override
    public Account deposit(int userid, int amount) {
        Client client = ClientBuilder.newBuilder().register(Integer.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath)
                .path(""+userid);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(amount, MediaType.APPLICATION_JSON));
        return response.readEntity(Account.class);
    }
}
