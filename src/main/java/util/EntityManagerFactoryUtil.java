package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class EntityManagerFactoryUtil {

    private EntityManagerFactory entityManagerFactory;
    private static EntityManagerFactoryUtil entityManagerFactoryUtil = null;

    private EntityManagerFactoryUtil(String persistenceUnitName) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName){
        if (entityManagerFactoryUtil == null) {
            entityManagerFactoryUtil = new EntityManagerFactoryUtil(persistenceUnitName);
        }
        return entityManagerFactoryUtil.getEntityManagerFactory();
    }

}
