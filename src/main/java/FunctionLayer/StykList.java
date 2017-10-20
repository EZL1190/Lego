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
public class StykList {
    private int width;
    private int length;
    private int high;
    private int id;

    public StykList(int width, int length, int high) {
        this.width = width;
        this.length = length;
        this.high = high;
    }
    
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHigh() {
        return high;
    }

    public int getTotal() {
        int w = width;
        int l = length-4;
        int four = 0;
        int two = 0;
        int one = 0;
        four = ((w/4) + (l/4)) * 2;
        two = (((w%4)/2) + ((l%4)/2)) * 2;
        one = ((((w%4)%2)/1) + (((l%4)%2)/1)) * 2;
        return (four + two + one) * high;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int[] side1()
    {
        int w = width;
        int l = length-4;
        int[] side1 = new int[3];
        side1[0] = (w/4)*2;
        side1[1] = ((w%4)/2)*2;
        side1[2] = (((w%4)%2)/1)*2;
        return side1;
    }
    
    public int[] side2()
    {
        int w = width;
        int l = length-4;
        int[] side2 = new int[3];
        side2[0] = (l/4)*2;
        side2[1] = ((l%4)/2)*2;
        side2[2] = (((l%4)%2)/1)*2;
        return side2;
    }
}
