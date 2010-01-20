/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class GroupDAOImpl implements GroupDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void saveGroup(Grupa group) {
        hibernateTemplate.saveOrUpdate(group);
    }

    public void deleteGroup(Grupa group) {
        hibernateTemplate.delete(group);
    }

    public void updateGroup(Grupa group) {
        hibernateTemplate.update(group);
    }
    
    public List<Grupa> listGroup() {
        return hibernateTemplate.find("from Grupa");
    }
    
    public Grupa getGroupById(int groupId) {
        for(Grupa group : this.listGroup()) {
            if(group.getId() == groupId) {
                return group;
            }
        }
        return null;
    }
}
