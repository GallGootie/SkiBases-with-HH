/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Cascade;
/**
 * Тип баз
 *
 * @author Alexander
 * edit by Anatol
 */
@Entity(name = "bases")
@Table(name = "bases")
public class Base implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long uid;

    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String adress;

    @Column
    private int blackCount;

    @Column
    private int greenCount;

    @Column
    private int redCount;

    @Column
    private int blueCount;

    @Column
    private int hourPrice;

    @Column
    private int nightPrice;

    @Column
    private boolean hasLightedSloves;

    @Column
    private boolean hasTrainers;

    @Column
    private boolean hasParking;

    @Column
    private boolean hasCaffe;

    @Column
    private boolean hasHotel;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @Fetch(FetchMode.SELECT)
    private List<Ski> skis;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @Fetch(FetchMode.SELECT)
    private List<Food> menuList;

    public Base() {
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isHasLightedSloves() {
        return hasLightedSloves;
    }

    public void setHasLightedSloves(boolean hasLightedSloves) {
        this.hasLightedSloves = hasLightedSloves;
    }

    public List<Food> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Food> menuList) {
        this.menuList = menuList;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public List<Ski> getSkis() {
        if (skis == null) {
            skis = new ArrayList<Ski>();

        }
        return skis;
    }

    public List<Food> getMenu() {
        if (menuList == null) {
            menuList = new ArrayList<Food>();

        }
        return menuList;
    }

    public int getBlackC() {
        return blackCount;
    }

    public int getBlueC() {
        return blueCount;
    }

    public int getGreenC() {
        return greenCount;
    }

    public int getRedC() {
        return redCount;
    }

    public int getHourPrice() {
        return hourPrice;
    }

    public int getNightPrice() {
        return nightPrice;
    }

    public boolean hasLight() {
        return hasLightedSloves;
    }

    public boolean hasTrainers() {
        return hasTrainers;
    }

    public boolean hasParking() {
        return hasParking;
    }

    public boolean hasCaffe() {
        return hasCaffe;
    }

    public boolean hasHotel() {
        return hasHotel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBlackCount(int count) {
        this.blackCount = count;
    }

    public void setBlueCount(int count) {
        this.blueCount = count;
    }

    public void setGreenCount(int count) {
        this.greenCount = count;
    }

    public void setRedCount(int count) {
        this.redCount = count;
    }

    public void setHourPrice(int price) {
        this.hourPrice = price;
    }

    public void setNightPrice(int price) {
        this.nightPrice = price;
    }

    public void setHasTrainers(boolean has) {
        this.hasTrainers = has;
    }

    public void setHasLight(boolean has) {
        this.hasLightedSloves = has;
    }

    public void setHasCaffe(boolean has) {
        this.hasCaffe = has;
    }

    public void setHasHotel(boolean has) {
        this.hasHotel = has;
    }

    public void setHasParking(boolean has) {
        this.hasParking = has;
    }

}
