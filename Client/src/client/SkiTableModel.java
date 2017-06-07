/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import api.obj.*;

/**
 *
 * @author Alexander
 */
public class SkiTableModel extends AbstractTableModel {

    private List<Ski> sks;

    @Override
    public int getRowCount() {
        return sks.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Название";
            case 1:
                return "Высота";
            case 2:
                return "Свободность";
            case 3:
                return "Арендователь";
            case 4:
                return "Раз сдано в аренду";
            case 5:
                return "id";

        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ski ski = sks.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return ski.getName();
            case 1:
                return ski.getHigh();
            case 2:
                return ski.isFree();
            case 3:
                return ski.getOwner();
            case 4:
                return ski.getUsedCount();
            case 5:
                return ski.getId();

        }

        return null;
    }

    public void addSki(Ski ski) {
        sks.add(ski);
        fireTableDataChanged();

    }

    public void deleteSki(Ski ski) {

        sks.remove(ski);
        fireTableDataChanged();
    }

    public Ski getSki(int rowIndex) {
        return sks.get(rowIndex);
    }

    public void setList(List<Ski> skies) {
        this.sks = skies;

    }

}
