package rest.interfaces;

import rest.DTO.Role;

/**
 * Created by magnus
 */
public interface AuthenticationClient {
    boolean login ();
    Role getRole ();
}
