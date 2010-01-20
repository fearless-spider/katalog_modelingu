/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import domain.Authority;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class AuthorityDAOImpl implements AuthorityDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void saveAuthority(Authority authority) {
        hibernateTemplate.saveOrUpdate(authority);
    }

    public void deleteAuthority(Authority authority) {
        hibernateTemplate.delete(authority);
    }

    public void updateAuthority(Authority authority) {
        hibernateTemplate.update(authority);
    }
    
    public List<Authority> listAuthority() {
        return hibernateTemplate.find("from Authority");
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

    public Authority getAuthorityById(int authorityId) {
        for(Authority authority : this.listAuthority()) {
            if(authority.getId() == authorityId) {
                return authority;
            }
        }
        return null;
    }

}
