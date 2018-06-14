package rest.interfaces;

import rest.DTO.Account;

/**
 * Created by magnus
 */
public interface AccountClient {
    Account getAccountForUser (int userid);
    Account withdraw (int userid, int amount);
    Account deposit (int userid, int amount);
}
