package by.edu.webstore.dao;

import by.edu.webstore.entity.Address;
import by.edu.webstore.exception.DaoException;

import java.util.List;
import java.util.Optional;


public interface AddressDao extends BaseDao<Address> {

    Optional<Address> findEntityById(long addressId) throws DaoException;

    List<Address> findUserAddresses(long userId) throws DaoException;

    long insertNewEntity(Address address) throws DaoException;

}
