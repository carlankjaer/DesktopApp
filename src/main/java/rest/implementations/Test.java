package rest.implementations;

import rest.DTO.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Created by magnus
 */
public class Test {
    private static final String RestService = "http://ec2-18-222-19-131.us-east-2.compute.amazonaws.com:8080/kreditsystem/api";

    public static User getUser() {
        Client client = ClientBuilder.newClient();
        User user = client.target(RestService)
                .path("customer").path("2")
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);
        return user;
    }

    public static void addUser () {

    }
}
