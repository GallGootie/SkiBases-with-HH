/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.util;

import api.obj.Base;
import api.obj.Food;
import api.obj.Ski;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Anatol
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/base")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "")
                    .setProperty("hibernate.connection.pool_size", "20")
                    .setProperty("hibernate.connection.autoReconnect", "true")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("connection.autoReconnectForPools", "true")
                    .setProperty("connection.is-connection-validation-required", "true")
                    .addAnnotatedClass(Base.class)
                    .addAnnotatedClass(Food.class)
                    .addAnnotatedClass(Ski.class);

            try {
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
