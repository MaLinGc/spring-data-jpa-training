package com.ml.repositories;

import com.ml.entities.Resource;

import javax.persistence.Query;
import java.util.List;

public class ResourceRepositoryImpl extends BaseRepository {

    public List<Resource> findUserResources(Long userId) {
        String sql = "select res from Resource res where res.id in (select rr.resource.id from ResourceRole rr where rr.role.id in (select ur.role.id from UserRole ur where ur.role.id = :userId))";
        Query query = em.createQuery(sql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
