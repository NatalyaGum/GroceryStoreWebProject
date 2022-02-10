package by.edu.webstore.controller.command.impl;

import by.edu.webstore.controller.command.Command;
import by.edu.webstore.controller.command.PagePath;
import by.edu.webstore.controller.command.Router;
import by.edu.webstore.entity.Product;
import by.edu.webstore.exception.CommandException;
import by.edu.webstore.exception.ServiceException;
import by.edu.webstore.service.ProductService;
import by.edu.webstore.service.ServiceProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.edu.webstore.controller.command.ParameterAndAttribute.PRODUCTS_LIST;

public class GoToCatalogCommand implements Command {

    private static final Logger logger = LogManager.getLogger();
    private static final ProductService productService = ServiceProvider.getInstance().getProductService();


    @Override
    public Router execute(HttpServletRequest request) throws CommandException {

        HttpSession session = request.getSession();
        try {
            List<Product> products=productService.findAllProducts();
            session.setAttribute(PRODUCTS_LIST, products);
            return new Router(PagePath.CATALOG, Router.RouterType.FORWARD);
        } catch (ServiceException e) {
            logger.error( "Impossible to find products:", e);
            throw new CommandException("Impossible to find products:", e);
        }

    }
}