package rest.implementations;

import rest.DTO.Role;
import rest.interfaces.AuthenticationClient;

/**
 * Created by magnus
 */
public class AuthenticationClientImpl implements AuthenticationClient{
    private static final String AuthenticationService = "http://ec2-18-222-19-131.us-east-2.compute.amazonaws.com:8080/kreditsystem/api/customer";

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public Role getRole() {
        return null;
    }
}
