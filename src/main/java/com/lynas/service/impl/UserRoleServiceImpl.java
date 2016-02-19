package com.lynas.service.impl;

import com.lynas.model.UserRole;
import com.lynas.service.UserRoleService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LynAs on 19-Feb-16
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public UserRole getRoleUser() {
        return (UserRole) sessionFactory
                .getCurrentSession()
                .createCriteria(UserRole.class)
                .add(Restrictions.eq("roleName", "ROLE_USER"))
                .uniqueResult();
    }
}
