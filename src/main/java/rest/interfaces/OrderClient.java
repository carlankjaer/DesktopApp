package rest.interfaces;

import rest.DTO.Order;
import rest.DTO.OrderRequest;
import rest.DTO.Status;

import java.util.List;

/**
 * Created by magnus
 */
public interface OrderClient {
    void addOrder(OrderRequest orderRequest);
    Order getOrder (int id);
    List<Order> getAllOrderByCustomerid (int userid);
    List<Order> getAllOrderByCompanyid (int companyid);
    List<Order> getAllOrderByEmployeeid (int employeeid);
    void updateOrderStatus (int id, Status status);
    void refundOrder (int id);
}
