package rest.implementations;

import rest.DTO.Order;
import rest.DTO.OrderRequest;
import rest.DTO.Status;
import rest.interfaces.OrderClient;

import java.util.List;

/**
 * Created by magnus
 */
public class OrderClientImpl implements OrderClient {
    @Override
    public void addOrder(OrderRequest orderRequest) {

    }

    @Override
    public Order getOrder(int id) {
        return null;
    }

    @Override
    public List<Order> getAllOrderByCustomerid(int userid) {
        return null;
    }

    @Override
    public List<Order> getAllOrderByCompanyid(int companyid) {
        return null;
    }

    @Override
    public List<Order> getAllOrderByEmployeeid(int employeeid) {
        return null;
    }

    @Override
    public void updateOrderStatus(int id, Status status) {

    }

    @Override
    public void refundOrder(int id) {

    }
}
