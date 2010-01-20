/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import dao.RangeDAO;
import domain.Range;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Przemysław Pająk <bespider@gmail.com>
 */
public class RangeController extends SimpleFormController {

    private RangeDAO rangeDAO;

    public void setRangeDAO(RangeDAO rangeDAO) {
        this.rangeDAO = rangeDAO;
    }

    @Override
    protected Object formBackingObject (HttpServletRequest request) throws Exception {
        Range range = new Range();
        range.setCreated(new java.util.Date());
        range.setModified(new java.util.Date());
        if(request.getParameter("id") != null) {
            range = rangeDAO.getRangeById(Integer.parseInt(request.getParameter("id")));
        }
        return range;
    }

    @Override
    public ModelAndView onSubmit(Object command) throws ServletException {
        rangeDAO.saveRange((Range)command);
        String message = "Zapisano zakres pracy";
        return new ModelAndView("message", "message", message);
    }
}
