package rest.DTO;

/**
 * Created by magnus
 */
public class JWT {
    // Den statiske instans af objektet
    private static JWT jwtInstance = null;

    //her skal json web token lægge
    private String token;

    private JWT() {
    }

    public static JWT getInstance()
    {
        if (jwtInstance == null)
            jwtInstance = new JWT();

        return jwtInstance;
    }

    public String getToken() {
        return token;
    }

    public void setToken (String token) {
        this.token = token;
    }

}
