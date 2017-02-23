package com.ml.repositories;

import com.ml.entities.User;
import com.ml.vo.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    public Page<User> findByFilter(Filter filter, Pageable pageable) {
        StringBuffer hql = new StringBuffer("from User u where 1 = 1 ");
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.hasText(filter.getName())) {
            hql.append("and u.name like :name ");
            parameterMap.put("name", "%" + filter.getName() + "%");
        }

        Query query = em.createQuery(hql.toString());
        for (Map.Entry<String, Object> entry : parameterMap.entrySet())
            query.setParameter(entry.getKey(), entry.getValue());
        return new PageImpl<>(query.getResultList(), pageable, 1);
    }
}
