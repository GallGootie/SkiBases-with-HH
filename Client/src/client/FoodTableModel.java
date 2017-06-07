/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import api.obj.*;

/**
 *
 * @author Alexander
 */
public class FoodTableModel extends AbstractTableModel {

    private Base base;

    @Override
    public int getRowCount() {
        return base.getMenu().size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Название";
            case 1:
                return "Цена";

        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Food food = base.getMenu().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return food.getName();
            case 1:
                return food.getPrice();

        }

        return null;
    }

    public void addFood(Food food) {
        base.getMenu().add(food);
        fireTableDataChanged();

    }

    public void deleteFood(Food food) {

        base.getMenu().remove(food);
        fireTableDataChanged();
    }

    public Food getFood(int rowIndex) {
        return base.getMenu().get(rowIndex);
    }

    public void setBase(Base mn) {
        this.base = mn;

    }

}
