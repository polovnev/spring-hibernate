package com.streetstat.dao.util;


import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Hibernate;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Can be used in Repositories and Services. Service methods should have Transactional annotation
 *
 * Example:
 * HibernateInitializer.initializeEntities(countries "cities", "cities.streets");
 */
public class HibernateInitializer {

    public static void initializeEntities(Object entity, String... properties) {
        for (String props: properties) {
            recursiveInitializeEntities(entity, props.split("\\."), 0);
        }
    }

    private static void recursiveInitializeEntities(Object entity, String[] innerEntityNames, int index) {
        if (entity instanceof Collection) {
            for (Object entityItem : (Collection) entity) {
                initializeInnerEntity(entityItem, innerEntityNames, index);
            }
        } else {
            initializeInnerEntity(entity, innerEntityNames, index);
        }
    }

    private static void initializeInnerEntity(Object entity, String[] innerEntityNames, int index) {
        try {
            Object innerEntity = PropertyUtils.getProperty(entity, innerEntityNames[index]);
            if (innerEntity != null) {
                Hibernate.initialize(innerEntity);
                if (++index < innerEntityNames.length) {
                    recursiveInitializeEntities(innerEntity, innerEntityNames, index);
                }
            }
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}