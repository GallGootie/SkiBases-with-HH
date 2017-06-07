/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JTable;

/**
 *
 * @author Alexander
 */
public class FoodTable extends JTable {

    public FoodTable() {
        super(new FoodTableModel());
        FoodTableCellRender renderer = new FoodTableCellRender();
        setDefaultRenderer(Boolean.class, renderer);
        setDefaultRenderer(Integer.class, renderer);
        setDefaultRenderer(String.class, renderer);
    }

}
