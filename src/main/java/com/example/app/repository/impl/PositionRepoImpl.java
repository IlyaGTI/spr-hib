package com.example.app.repository.impl;

import com.example.app.model.Position;
import com.example.app.repository.PositionRepo;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PositionRepoImpl implements PositionRepo {

    private final LocalSessionFactoryBean localSessionFactoryBean;

    public PositionRepoImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        this.localSessionFactoryBean = localSessionFactoryBean;
    }

    @Override
    public List<Position> allPositions() {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        return session.createQuery("from Position ").getResultList();
    }

    @Override
    public Position getById(Long id) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        return session.get(Position.class, id);
    }

    @Override
    public void updatePosition(Position position) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.saveOrUpdate(position);

    }

    @Override
    public Position createPosition(Position position) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(position);
        return position;
    }

    @Override
    public void deletePosition(Position position) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.delete(position);
    }
}
