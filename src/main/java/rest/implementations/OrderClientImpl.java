package rest.implementations;

import rest.DTO.JWT;
import rest.DTO.Order;
import rest.DTO.OrderRequest;
import rest.DTO.Status;
import rest.interfaces.OrderClient;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
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
public class OrderClientImpl implements OrderClient {
    private String servicePath = "order";
    @Override
    public Order addOrder(OrderRequest orderRequest) throws NotAuthorizedException {
        Client client = ClientBuilder.newBuilder().register(Order.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath);
        Response response = target.request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(orderRequest, MediaType.APPLICATION_JSON));
        return response.readEntity(Order.class);
    }

    @Override
    public Order getOrder(int id) throws NotFoundException {
        Client client = ClientBuilder.newClient();
        Order order = client.target(DefaultClientImpl.restService)
                .path(servicePath)
                .request(MediaType.APPLICATION_JSON)
                .get(Order.class);
        return order;
    }

    @Override
    public List<Order> getAllOrderByCustomerid(int userid) throws NotFoundException, NotAuthorizedException {
        Client client = ClientBuilder.newClient();
        List<Order> orders = client.target(DefaultClientImpl.restService)
                .path(servicePath+"/customer")
                .path(""+userid)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Order>>() {});
        return orders;
    }

    @Override
    public Order updateOrderStatus(int id, Status status) throws NotFoundException, NotAuthorizedException {
        Client client = ClientBuilder.newBuilder().register(Order.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath);
        Response response = target.request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .put(Entity.entity(status, MediaType.APPLICATION_JSON));
        return response.readEntity(Order.class);
    }

    @Override
    public Order refundOrder(int id) throws NotFoundException, NotAuthorizedException {
        Client client = ClientBuilder.newBuilder().register(Order.class).build();
        WebTarget target = client.target(DefaultClientImpl.restService)
                .path(servicePath+"/refund")
                .path(""+id);
        Response response = target.request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+ JWT.getInstance().getToken())
                .accept(MediaType.APPLICATION_JSON)
                .post(null);
        return response.readEntity(Order.class);
    }
}
