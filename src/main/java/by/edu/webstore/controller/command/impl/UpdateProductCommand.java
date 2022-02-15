package by.edu.webstore.controller.command.impl;

import by.edu.webstore.controller.command.Command;
import by.edu.webstore.controller.command.PagePath;
import by.edu.webstore.controller.command.ParameterAndAttribute;
import by.edu.webstore.controller.command.Router;
import by.edu.webstore.entity.Product;
import by.edu.webstore.entity.User;
import by.edu.webstore.exception.CommandException;
import by.edu.webstore.exception.ServiceException;
import by.edu.webstore.service.ProductService;
import by.edu.webstore.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UpdateProductCommand implements Command {

        static Logger logger = LogManager.getLogger();
        private static final ProductService productService = ServiceProvider.getInstance().getProductService();
        private static final String PRODUCT_ERROR_MESSAGE_KEY = "error.update_product";
        private static final String PRODUCT_CONFIRM_MESSAGE_KEY = "confirm.update_product";

        @Override
        public Router execute (HttpServletRequest request) throws CommandException {

            HttpSession session = request.getSession();
            Long product_id = Long.parseLong(request.getParameter(ParameterAndAttribute.PRODUCT_ID));
            Map<String, String> productData = new HashMap<>();
            productData.put(ParameterAndAttribute.PRODUCT_ID, Long.toString(product_id));
            productData.put(ParameterAndAttribute.TITLE, request.getParameter(ParameterAndAttribute.TITLE));
            productData.put(ParameterAndAttribute.DESCRIPTION, request.getParameter(ParameterAndAttribute.DESCRIPTION));
            productData.put(ParameterAndAttribute.MANUFACTURE, request.getParameter(ParameterAndAttribute.MANUFACTURE));
            productData.put(ParameterAndAttribute.PRICE, request.getParameter(ParameterAndAttribute.PRICE));
            productData.put(ParameterAndAttribute.TYPE, request.getParameter(ParameterAndAttribute.TYPE));
            productData.put(ParameterAndAttribute.ACTIVE, request.getParameter(ParameterAndAttribute.ACTIVE));
            try {
                Part imagePart = request.getPart(ParameterAndAttribute.IMAGE);
                if (imagePart!=null){
                InputStream imageInputStream = imagePart.getInputStream();
                if (productService.updateProduct(productData, imageInputStream)) {
                    session.setAttribute(ParameterAndAttribute.MESSAGE, PRODUCT_CONFIRM_MESSAGE_KEY);
                    Optional<Product> optionalProduct=productService.getProductById (product_id) ;
                    request.setAttribute(ParameterAndAttribute.PRODUCT, optionalProduct.get());
                    return new Router(PagePath.PRODUCT_EDIT, Router.RouterType.FORWARD);
                } else {
                    request.setAttribute(ParameterAndAttribute.PRODUCT, productData);
                    request.setAttribute(ParameterAndAttribute.MESSAGE, PRODUCT_ERROR_MESSAGE_KEY);
                    // request.setAttribute(PRODUCT_CREATION_RESULT, INVALID);
                    return new Router(PagePath.PRODUCT_EDIT, Router.RouterType.FORWARD);
                }}else if (productService.updateProduct(productData)) {
                    session.setAttribute(ParameterAndAttribute.MESSAGE, PRODUCT_CONFIRM_MESSAGE_KEY);
                    Optional<Product> optionalProduct=productService.getProductById (product_id) ;
                    request.setAttribute(ParameterAndAttribute.PRODUCT, optionalProduct.get());
                    return new Router(PagePath.PRODUCT_EDIT, Router.RouterType.FORWARD);
                }  else { request.setAttribute(ParameterAndAttribute.PRODUCT, productData);
                    request.setAttribute(ParameterAndAttribute.MESSAGE, PRODUCT_ERROR_MESSAGE_KEY);
                    // request.setAttribute(PRODUCT_CREATION_RESULT, INVALID);
                    return new Router(PagePath.PRODUCT_EDIT, Router.RouterType.FORWARD);}

                //List<Product> products = productService.findAllProducts();
                // session.setAttribute(PRODUCT_LIST, PRODUCTS);

            } catch (ServiceException e) {
                logger.error("Impossible to update product:", e);
                throw new CommandException("Impossible to update product:", e);
            } catch (ServletException | IOException e) {
                logger.error("Impossible to get image of product", e);
                throw new CommandException("Impossible to get image of product:", e);
            }
        }
    }