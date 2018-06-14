package rest.interfaces;

import rest.DTO.LoginDetails;
import rest.DTO.Role;

import javax.ws.rs.NotAuthorizedException;

/**
 * Created by magnus
 */
public interface AuthenticationClient {
    String login (LoginDetails loginDetails) throws NotAuthorizedException;
    Role getRole () throws NotAuthorizedException;
}
