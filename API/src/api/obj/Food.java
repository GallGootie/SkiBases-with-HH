/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.obj;

import java.io.Serializable;
import javax.persistence.*;

/**
 * тип Еда
 *
 * @author Alexander
 * edit by Anatol
 */
@Entity(name = "food")
@Table(name = "food")
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public Food() {
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String nme) {
        this.name = nme;
    }

    public void setPrice(String prce) {
        this.price = prce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
