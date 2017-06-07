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
public class SkiTable extends JTable {

    public SkiTable() {
        super(new SkiTableModel());
        SkiTableCellRender renderer = new SkiTableCellRender();
        setDefaultRenderer(Boolean.class, renderer);
        setDefaultRenderer(Integer.class, renderer);
        setDefaultRenderer(String.class, renderer);
    }

}
