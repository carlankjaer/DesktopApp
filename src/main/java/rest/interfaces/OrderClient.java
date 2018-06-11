package rest.interfaces;

import rest.DTO.Order;
import rest.DTO.OrderRequest;
import rest.DTO.Status;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by magnus
 */
public interface OrderClient {
    Order addOrder (OrderRequest orderRequest) throws NotAuthorizedException;
    Order getOrder (int id) throws NotFoundException, NotAuthorizedException;
    List<Order> getAllOrderByCustomerid (int userid) throws NotAuthorizedException;
    Order updateOrderStatus (int id, Status status) throws NotFoundException, NotAuthorizedException;
    Order refundOrder (int id) throws NotFoundException, NotAuthorizedException;
}
