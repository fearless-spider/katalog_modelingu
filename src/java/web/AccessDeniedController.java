/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.SimpleFormController;
/**
 *
 * @author uniqueblackrose
 */

public class AccessDeniedController extends SimpleFormController {
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        dataMap.put("access", "");

        return dataMap;
    }
}