/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.obj;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Лыжи 
 *
 * @author Alexander
 * edit by Anatol
 */
@Entity(name = "ski")
@Table(name = "ski")
public class Ski implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long uid;

    @Column
    private String name;

    @Column
    private String high;

    @Column
    private int usedCount = 0;

    @Column
    public String id;

    @Column
    private boolean isFree;

    @Column
    private String owner;

    public void wasOwned(String owne) {
        usedCount += 1;
        owner = owne;
        isFree = false;

    }

    public Ski() {
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean is) {
        this.isFree = is;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(int usedCount) {
        this.usedCount = usedCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
