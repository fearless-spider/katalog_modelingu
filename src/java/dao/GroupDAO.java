/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import java.util.List;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public interface GroupDAO {

    public void saveGroup(Grupa group);
    public void deleteGroup(Grupa group);
    public void updateGroup(Grupa group);
    public List<Grupa> listGroup();
    public Grupa getGroupById(int groupId);
}
