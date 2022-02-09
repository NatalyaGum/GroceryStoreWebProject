package by.edu.webstore.dao;


import by.edu.webstore.exception.DaoException;
import by.edu.webstore.entity.Product;
import by.edu.webstore.entity.ProductType;
import by.edu.webstore.exception.ConnectionPoolException;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;


public interface ProductDao extends BaseDao<Product> {
    Optional<Product> findEntityById(long id) throws DaoException;

    List<Product> findAllEntities() throws DaoException;

    long insertNewEntity(Product entity) throws DaoException, ConnectionPoolException;

    long insertNewEntity(Product product, InputStream image) throws DaoException;

    boolean isProductExist(String title) throws DaoException;

    List<Product> findProductsByType(ProductType type) throws DaoException;

    boolean updateProductStatusById(boolean active, Long productId) throws DaoException;
    List<ProductType> findAllProductTypes() throws DaoException;
    long insertNewProductType (String productTypeData )throws DaoException;
    boolean modifyProductType(String oldProductType, String newProductType) throws DaoException;
    boolean deleteProductType(String oldProductType) throws DaoException;
    boolean isEmptyType(String oldProductType) throws DaoException;
}



