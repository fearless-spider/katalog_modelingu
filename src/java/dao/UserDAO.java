/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import domain.Range;
import domain.User;
import java.util.List;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public interface UserDAO {

    public void saveUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public List<User> listUser();
    public List<User> getUsers();
    public List<Range> getUserRanges(int id);
    public List<Range> listRange();
    public List<Grupa> listGroup();
    public List<Grupa> listGroupWithoutAdmin();
    public List<User> listUsersWithoutAdmin();
    public User getUserById(int userId);
    public Grupa getGroupById(int groupId);
    public Range getRangeById(int rangeId);
    public User getUserByName(String username);
    public List<User> getUsersByGroup(Grupa group);
}
