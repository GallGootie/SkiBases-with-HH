/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import layout.TableLayout;
import api.obj.*;

/**
 *
 * @author Alexander
 */
public class SkisEditingDialog extends JDialog {

    private SkiTable skiTable;
    private JPanel panel;
    private JTextField name;
    private JTextField high;
    private JTextField id;
    public Base bse;

    private JButton create;
    private JButton delete;

    private boolean isNew = true;

    private Ski ski;

    private boolean who;

    public SkisEditingDialog(Frame owner, String title, boolean modal, Base bse, boolean who) {
        super(owner, title, modal);
        this.bse = bse;
        this.who = who;

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        skiTable = new SkiTable();
        if (who) {
            ((SkiTableModel) skiTable.getModel()).setList(bse.getSkis());
        }
        ((SkiTableModel) skiTable.getModel()).fireTableDataChanged();
        name = new JTextField();
        name.setBorder(BorderFactory.createTitledBorder("Название"));
        high = new JTextField();
        high.setBorder(BorderFactory.createTitledBorder("Высота"));

        id = new JTextField();
        id.setBorder(BorderFactory.createTitledBorder("id"));

        skiTable.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                int t = e.getClickCount();
                if (t == 2) {
                    int i = skiTable.getSelectedRow();
                    ski = ((SkiTableModel) skiTable.getModel()).getSki(i);
                    name.setText(ski.getName());
                    high.setText(ski.getHigh());
                    id.setText(ski.id);
                    isNew = false;
                }
            }
        });

        create = new JButton("добавить");
        create.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isNew) {
                    ski = new Ski();
                }

                ski.setName(name.getText());
                ski.setHigh(high.getText());
                ski.id = id.getText();
                ski.setFree(true);
                ((SkiTableModel) skiTable.getModel()).addSki(ski);
                name.setText("Название");
                high.setText("");
                id.setText("");
                isNew = true;

            }

        });

        delete = new JButton("Удалить");
        delete.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ((SkiTableModel) skiTable.getModel()).deleteSki(ski);
                name.setText("Название");
                high.setText("");
                id.setText("");
                isNew = true;

            }
        });

        panel = new JPanel();
        double size[][]
                = {{90, 90, 80, 0.5, 0.5},
                {50}};
        panel.setLayout(new TableLayout(size));

        panel.add(name, "0,0");
        panel.add(high, "1,0");
        panel.add(id, "2,0");
        panel.add(create, "3,0");
        panel.add(delete, "4,0");
        contentPane.add(new JScrollPane(skiTable), BorderLayout.SOUTH);
        contentPane.add(panel, BorderLayout.NORTH);

        pack();
        setResizable(true);
        setLocationRelativeTo(getParent());

    }

    public void setBase(Base base, boolean wich) {
        this.bse = base;
        this.who = wich;
    }

}
