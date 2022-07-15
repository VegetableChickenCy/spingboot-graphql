package com.mx.server.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerUtil {
    private static EntityManagerFactory cicifactory = null;

    private static EntityManagerUtil instance = null;

    private EntityManagerUtil(){

        Map<String,String> properties = new HashMap<String,String>();
        properties.put ("javax.persistence.jdbc.user", "SA");
        properties.put("javax.persistence.jdbc.password", "Sql@123456");
        properties.put("javax.persistence.jdbc.driver","com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put("javax.persistence.jdbc.url","jdbc:sqlserver://127.0.0.1:1433;databaseName=graphsql;user=SA;password=Sql@123456");
        cicifactory = Persistence.createEntityManagerFactory("myJpa", properties);

    }

/*Singleton :lazy loading :initail the

To ensure that the whole APP share one EntityManagerUtil instance

*/

    public EntityManagerFactory getEntityManagerFactory(){
        return cicifactory;
    }


    public synchronized static EntityManagerUtil getInstance(){

        if(instance==null){

            instance = new EntityManagerUtil();

        }

        return instance;

    }

    public EntityManager getCICIEntityManager(){

        return cicifactory.createEntityManager();

    }

    public  void releaseEntityManager(final EntityManager entityManager){

        entityManager.close();

    }

    public void destory(){
        instance = null;
        cicifactory.close();
    }

}
