package rest.implementations;

import rest.DTO.JWT;
import rest.DTO.Product;
import rest.interfaces.ProductClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by magnus
 */
public class ProductClientImpl extends DefaultClientImpl<Product> implements ProductClient {
    public ProductClientImpl() {
        super("product", Product.class, new GenericType<List<Product>>() {});
    }

    public Product postProduct (Product product, int categoryid) {
        Client client = ClientBuilder.newBuilder().register(Product.class).build();
        WebTarget target = client.target(restService)
                .path("product")
                .path(""+categoryid);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(product, MediaType.APPLICATION_JSON));
        return response.readEntity(Product.class);
    }
}
