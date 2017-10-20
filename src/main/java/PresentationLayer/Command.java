package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of Command is to...

 @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "createOrder", new CreateOrder() );
        commands.put( "getOrders", new GetOrders() );
        commands.put( "getOrder", new GetOrder() ); //get's unknown command
        commands.put( "sendOrders", new SendOrders() ); // can't test it, since i can't get to the .jsp site
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" ); 
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException;

}
