/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Range;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class RangeDAOImpl implements RangeDAO {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void saveRange(Range range) {
        hibernateTemplate.saveOrUpdate(range);
    }

    public void deleteRange(Range range) {
        hibernateTemplate.delete(range);
    }

    public void updateRange(Range range) {
        hibernateTemplate.update(range);
    }
    
    public List<Range> listRange() {
        return hibernateTemplate.find("from Range");
    }

    public Range getRangeById(int rangeId) {
        for(Range range : this.listRange()) {
            if(range.getId() == rangeId) {
                return range;
            }
        }
        return null;
    }
}
