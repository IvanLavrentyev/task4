package util;

import javax.persistence.EntityManager;

public class EntityManagerUtil {

    public static EntityManager getEntityManager(String persistenceUnitName){
        return EntityManagerFactoryUtil.
                getEntityManagerFactory(persistenceUnitName).
                createEntityManager();
    }
}
