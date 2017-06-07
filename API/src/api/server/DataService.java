/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.server;

import api.obj.Base;
import java.util.List;

/**
 *объявление методов для работы с БД
 * 
 * @author Anatol
 */
public interface DataService {

    void setBaseList(List<Base> list);
    void delBase(Base base);
    List<Base> getBaseList();
}
