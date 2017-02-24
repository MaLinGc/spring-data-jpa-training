package com.ml.repositories;

import com.ml.entities.Role;

import javax.persistence.Query;
import java.util.List;

public class RoleRepositoryImpl extends BaseRepository {

    public List<Role> findRoleByUserId(Long userId) {
        String hql = "select r from Role r where r.id in (select distinct ur.role.id from UserRole ur where ur.user.id = :userId) ";
        Query query = em.createQuery(hql.toString());
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
