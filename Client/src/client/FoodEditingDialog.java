/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.text.WebFormattedTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import layout.TableLayout;
import api.obj.*;

/**
 *
 * @author Alexander
 */
public class FoodEditingDialog extends JDialog {

    private JPanel panel;
    private JTextField name;

    private JTextField price;

    private JButton add;
    private JButton delete;

    private FoodTable foodTable;

    private Food food;

    private Base menu;

    private boolean isNew = true;

    public FoodEditingDialog(Frame owner, String title, boolean modal, Base menu) {
        super(owner, title, modal);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        foodTable = new FoodTable();

        foodTable.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int t = e.getClickCount();
                if (t == 2) {
                    int i = foodTable.getSelectedRow();
                    food = ((FoodTableModel) foodTable.getModel()).getFood(i);
                    name.setText(food.getName());
                    price.setText(food.getPrice());
                    isNew = false;
                }
            }

        });

        ((FoodTableModel) foodTable.getModel()).setBase(menu);
        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder("Название"));
        price = new JTextField();
        price.setBorder(BorderFactory.createTitledBorder("Цена"));

        add = new JButton("добавить");
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNew) {
                    food = new Food();
                }
                food.setName(name.getText());
                food.setPrice(price.getText());
                ((FoodTableModel) foodTable.getModel()).addFood(food);
                name.setText("Название");
                price.setText("");
                isNew = true;

            }
        });
        delete = new JButton("Удалить");
        delete.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((FoodTableModel) foodTable.getModel()).deleteFood(food);
                name.setText("Название");
                price.setText("");
                isNew = true;
            }
        });

        panel = new JPanel();
        double size[][]
                = {{0.3, 0.3, 0.2, 0.2},
                {50}};
        panel.setLayout(new TableLayout(size));

        panel.add(name, "0,0");
        panel.add(price, "1,0");
        panel.add(add, "2,0");
        panel.add(delete, "3,0");

        contentPane.add(new JScrollPane(foodTable), BorderLayout.SOUTH);
        contentPane.add(panel, BorderLayout.NORTH);

        pack();
        setResizable(true);
        setLocationRelativeTo(getParent());

    }

    public void setBase(Base mne) {
        this.menu = mne;
    }

}
