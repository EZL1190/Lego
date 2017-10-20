/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.StykList;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ezl
 */
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int width = Integer.parseInt(request.getParameter("wide"));
        int length = Integer.parseInt(request.getParameter("long"));
        int hight = Integer.parseInt(request.getParameter("high"));
        StykList stykList = new StykList(width, length, hight);
        LogicFacade.createOrder(stykList, user);
        return user.getRole() + "page";
    }
    
}
