package by.edu.webstore.controller.command;

import by.edu.webstore.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;
import java.util.Map;

/**
 * {@code CommandProvider} class represent the relations between {@link CommandType} and {@link Command}
 * Hold and provide instance of all classes extends {@link Command}
 */
public class CommandProvider {
    static Logger logger = LogManager.getLogger();

    private static Map<CommandType, Command> commands = new EnumMap<>(CommandType.class);

    static {
        commands.put(CommandType.FIND_ALL_USERS, new FindAllUsersCommand());
        commands.put(CommandType.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
        commands.put(CommandType.GO_TO_REGISTRATION, new GoToRegistrationCommand());
        commands.put(CommandType.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandType.SIGN_UP, new SignUpCommand());
        commands.put(CommandType.SIGN_IN, new SignInCommand());
        commands.put(CommandType.ADD_PRODUCT, new AddProductCommand());
        commands.put(CommandType.GO_TO_PRODUCT_ADD, new GoToProductAddCommand());
        commands.put(CommandType.ADD_PRODUCT_TYPE, new AddProductTypeCommand());
        commands.put(CommandType.MODIFY_PRODUCT_TYPE, new UpdateProductTypeCommand());
        commands.put(CommandType.GO_TO_CATALOG, new GoToCatalogCommand());
        commands.put(CommandType.SIGN_OUT, new SignOutCommand());
        commands.put(CommandType.GO_TO_AUTHORIZATION, new GoToAuthorizationPageCommand());
        commands.put(CommandType.PRODUCT_MAINTENANCE, new ProductMaintenanceCommand());
        commands.put(CommandType.EDIT_PRODUCT, new UpdateProductCommand());
        commands.put(CommandType.GO_TO_EDIT_PRODUCT, new GoToEditCommand());
        commands.put(CommandType.UPDATE_PICTURE, new UpdatePictureCommand());
        commands.put(CommandType.GO_TO_CART, new GoToCartCommand());
        commands.put(CommandType.GO_TO_ADD_ADDRESS, new GoToAddAddressCommand());
        commands.put(CommandType.ADD_ADDRESS, new AddAddressCommand());
        commands.put(CommandType.CREATE_ORDER, new AddOrderCommand());
        commands.put(CommandType.GO_TO_ORDERS, new GoToOrdersCommand());
        commands.put(CommandType.GO_TO_PRODUCT_TYPE, new GoToProductTypeCommand());
        commands.put(CommandType.GO_TO_ORDERS_ADMIN, new GoToOrdersAdminCommand());
        commands.put(CommandType.GO_TO_UPDATE_PROFILE, new GoToUpdateProfileCommand());
        commands.put(CommandType.UPDATE_PROFILE, new UpdateProfileCommand());
        commands.put(CommandType.GO_TO_USER_MAINTENANCE, new GoToUserMaintenanceCommand());
        commands.put(CommandType.SEARCH, new Search());
    }

    private CommandProvider() {
    }

    public static Command defineCommand(String commandName) {
        if (commandName == null) {
            logger.error("null command");
            return commands.get(CommandType.GO_TO_MAIN_PAGE);
        }
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("no such command name " + commandName, e);
            commandType = CommandType.GO_TO_MAIN_PAGE;
        }
        return commands.get(commandType);
    }
}
