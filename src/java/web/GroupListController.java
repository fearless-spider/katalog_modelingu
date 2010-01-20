/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.GroupDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class GroupListController implements Controller {

    GroupDAO groupDAO;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("groupList");
        if(request.getParameter("id") != null) {
            if(Integer.parseInt(request.getParameter("id")) > 0) {
                groupDAO.deleteGroup(groupDAO.getGroupById(Integer.parseInt(request.getParameter("id"))));
            }
        }
        modelAndView.addObject("groupList", this.groupDAO.listGroup());

        return modelAndView;
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

}
