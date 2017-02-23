package com.ml.repositories;

import com.ml.entities.Permission;
import com.ml.vo.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionRepositoryImpl {

    Logger logger = LoggerFactory.getLogger(PermissionRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    public List<Permission> findByFilter(Filter filter) {
        logger.debug("findByFilter...");

        StringBuffer hql = new StringBuffer("from Permission p left join fetch p.permissionGroup pg where 1 = 1 ");
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.hasText(filter.getName())) {
            hql.append("and pg.groupName like :groupName ");
            parameterMap.put("groupName" , "%" + filter.getName() + "%");
        }

        Query query = em.createQuery(hql.toString());
        for (Map.Entry<String, Object> entry : parameterMap.entrySet())
            query.setParameter(entry.getKey(), entry.getValue());
        return query.getResultList();
    }
}
