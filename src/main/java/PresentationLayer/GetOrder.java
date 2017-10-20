/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezl
 */
public class GetOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String[] checksid = request.getParameterValues("checks");
        List<String> values = Arrays.asList(checksid);
        List<String> colm = new ArrayList<>();
        for(int i = 0; i < values.size(); i++)
        {
            LogicFacade.updateOrder(colm, values, Integer.parseInt(values.get(i)));
        }
        return "orderpage";
    }
    
}
