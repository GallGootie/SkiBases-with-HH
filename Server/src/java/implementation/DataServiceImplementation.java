/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import api.obj.Base;
import api.server.DataService;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Anatol
 */
public class DataServiceImplementation implements DataService {

    @Override
    public void setBaseList(List<Base> list) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                session.saveOrUpdate(list.get(i));
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Base> getBaseList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Base> list = session.createQuery("SELECT E FROM bases E").getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public void delBase(Base base) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(base);
            session.getTransaction().commit();
        }
    }
   
}
