package com.infoshareacademy.dao;

import com.infoshareacademy.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Course c) {
        entityManager.persist(c);
        return c.getId();
    }

    public Course update(Course c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final Course c = entityManager.find(Course.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public List<Course> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM Course s");

        return query.getResultList();
    }
}
