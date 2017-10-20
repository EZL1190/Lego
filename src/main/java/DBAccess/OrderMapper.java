/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.StykList;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ezl
 */
public class OrderMapper {
    public static void createOrder(StykList stykList, User user) throws LoginSampleException 
    {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `Order` SET Order_wide = ?, Order_long = ?, Order_high = ?, fk_user_id = ?";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, stykList.getWidth());
            ps.setInt(2, stykList.getLength());
            ps.setInt(3, stykList.getHigh());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    
    public static List<Order> getOrders(int id) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Order_id, Order_date, Order_sendt, Order_wide, Order_long, Order_high FROM `Order` WHERE fk_user_id = ? ORDER BY Order_id DESC";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Order> orders = new ArrayList<>();
            while(rs.next())
            {
                orders.add(new Order
                    (rs.getInt("Order_id")
                    , rs.getString("Order_date")
                    , rs.getBoolean("Order_sendt")
                    , new StykList
                        (rs.getInt("Order_wide")
                        , rs.getInt("Order_long")
                        , rs.getInt("Order_high")
                        )
                    )
                );
            }
            return orders;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    
    public static List<Order> getOrders() throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Order_id, Order_date, Order_sendt, Order_wide, Order_long, Order_high FROM `Order` ORDER BY Order_id DESC";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ResultSet rs = ps.executeQuery();
            List<Order> orders = new ArrayList<>();
            while(rs.next())
            {
                orders.add(new Order
                    (rs.getInt("Order_id")
                    , rs.getString("Order_date")
                    , rs.getBoolean("Order_sendt")
                    , new StykList
                        (rs.getInt("Order_wide")
                        , rs.getInt("Order_long")
                        , rs.getInt("Order_high")
                        )
                    )
                );
            }
            return orders;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    
    public static Order getOrder(int id) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT Order_id, Order_date, Order_sendt, Order_wide, Order_long, Order_high FROM `Order`";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return new Order
                    (rs.getInt("Order_id")
                    , rs.getString("Order_date")
                    , rs.getBoolean("Order_sendt")
                    , new StykList
                        (rs.getInt("Order_wide")
                        , rs.getInt("Order_long")
                        , rs.getInt("Order_high")
                        )
                    );
            }
            return null;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    
    public static void updateOrder(List<String> colm, List<String> values, int id) throws LoginSampleException
    {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `Order` SET";
            for(int i = 0; i < colm.size(); i++)
            {
                if(i == 0)
                    SQL += colm.get(i) + " = ?, ";
                else if(i == 1)
                    SQL += colm.get(i) + " = ?";
                else
                    SQL += ", " + colm.get(i);
            }
            SQL += " WHERE Order_id = ?"; 
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            for(int i = 0; i < values.size(); i++)
            {
                if(values.get(i).matches("[0-9]+"))
                    ps.setInt(i, Integer.parseInt(values.get(i)));
                else
                    ps.setString(i, values.get(i));
            }
            ps.setInt(values.size()+1, id);
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}
