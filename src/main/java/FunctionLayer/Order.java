/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author ezl
 */
public class Order {
    private int id;
    private String date;
    private boolean sendt;
    private StykList stykList;

    public Order(int id, String date, boolean sendt, StykList stykList) {
        this.id = id;
        this.date = date;
        this.sendt = sendt;
        this.stykList = stykList;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public boolean isSendt() {
        return sendt;
    }

    public StykList getStykList() {
        return stykList;
    }
    
    
    
}
