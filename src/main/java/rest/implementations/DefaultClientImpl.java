package rest.implementations;

import rest.interfaces.DefaultClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by magnus
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class DefaultClientImpl<T> implements DefaultClient<T> {
    public static final String restService = "http://ec2-18-222-19-131.us-east-2.compute.amazonaws.com:8080/kreditsystem/api";
    private String servicePath;
    private Class<T> type;
    private GenericType<List<T>> listType;
    public DefaultClientImpl(String servicePath, Class<T> type, GenericType<List<T>> listType) {
        this.servicePath = servicePath;
        this.type = type;
        this.listType = listType;
    }

    @Override
    public List<T> getAll() {
        Client client = ClientBuilder.newClient();
        List<T> elements = client.target(restService)
                .path(servicePath)
                .request(MediaType.APPLICATION_JSON)
                .get(listType);
        return elements;
    }

    @Override
    public T get(int id) {
        Client client = ClientBuilder.newClient();
        T element = client.target(restService)
                .path(servicePath)
                .path(""+id)
                .request(MediaType.APPLICATION_JSON)
                .get(type);
        return element;
    }

    @Override
    public T post(T element) {
        Client client = ClientBuilder.newBuilder().register(type).build();
        WebTarget target = client.target(restService)
                .path(servicePath);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(element, MediaType.APPLICATION_JSON));
        return response.readEntity(type);
    }

    @Override
    public T delete(int id) {
        Client client = ClientBuilder.newBuilder().register(Integer.class).build();
        WebTarget target = client.target(restService)
                .path(servicePath)
                .path(""+id);
        Response response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .delete();
        return response.readEntity(type);
    }

    @Override
    public T put(int id, T element) {
        Client client = ClientBuilder.newBuilder().register(type).build();
        WebTarget target = client.target(restService)
                .path(servicePath)
                .path(""+id);
        Response response = target.request()
                .accept(MediaType.APPLICATION_JSON)
                .put(Entity.entity(element, MediaType.APPLICATION_JSON));
        return response.readEntity(type);
    }
}
