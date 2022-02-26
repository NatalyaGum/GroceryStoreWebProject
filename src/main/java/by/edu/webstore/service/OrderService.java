package by.edu.webstore.service;

import by.edu.webstore.entity.Address;
import by.edu.webstore.entity.Order;
import by.edu.webstore.entity.Product;
import by.edu.webstore.exception.DaoException;
import by.edu.webstore.exception.ServiceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {
     long insertNewAddress(Map<String, String> addressData) throws ServiceException ;
     List<Address> findUserAddresses(long userId) throws ServiceException;
     long  insertNewOrder(Map<String, Object> orderData, HashMap<Product, Integer> productMap)throws ServiceException;
     List<Order> findAllOrdersOfUser(long user_id,int offset, int limit) throws ServiceException;
     int findTotalOrdersNumber (long user_id) throws ServiceException;
}
