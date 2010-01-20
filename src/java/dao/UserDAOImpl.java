/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import domain.Range;
import domain.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class UserDAOImpl implements UserDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public void saveUser(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }

    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    public List<User> listUser() {
        return hibernateTemplate.find("select u,g  from User u inner join fetch u.groups g group by u.id");
    }
    public List<User> getUsers() {
        return hibernateTemplate.find("from User");
    }

    public List<Range> getUserRanges(int id) {
        return hibernateTemplate.find("select r from Range r inner join fetch r.userses u where u.id = ? group by r.id", id);
    }

    public List<User> getUsersByGroup(Grupa group) {
        return hibernateTemplate.find("select distinct u from User u inner join fetch u.groups g left join fetch u.rangieses r where g = ? order by u.id", group);
    }

    public List<Range> listRange() {
        return hibernateTemplate.find("from Range");
    }
    
    public List<Grupa> listGroup() {
        return hibernateTemplate.find("from Grupa");
    }

    public List<Grupa> listGroupWithoutAdmin() {
        return hibernateTemplate.find("select g from Grupa g where g.id > 1");
    }

    public List<User> listUsersWithoutAdmin() {
        return hibernateTemplate.find("select u from User u inner join fetch u.groups g where g.id > 1");
    }

    public User getUserById(int userId) {
        for(User user : this.listUser()) {
            if(user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public Grupa getGroupById(int groupId) {
        for(Grupa group : this.listGroup()) {
            if(group.getId() == groupId) {
                return group;
            }
        }
        return null;
    }

    public Range getRangeById(int rangeId) {
        for(Range range : this.listRange()) {
            if(range.getId() == rangeId) {
                return range;
            }
        }
        return null;
    }

    public User getUserByName(String username) {
        for(User user : this.listUser()) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


}
