/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Grupa;
import domain.Authority;
import java.util.List;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public interface AuthorityDAO {

    public void saveAuthority(Authority authority);
    public void deleteAuthority(Authority authority);
    public void updateAuthority(Authority authority);
    public List<Authority> listAuthority();
    public List<Grupa> listGroup();
    public Grupa getGroupById(int groupId);
    public Authority getAuthorityById(int authorityId);
}
