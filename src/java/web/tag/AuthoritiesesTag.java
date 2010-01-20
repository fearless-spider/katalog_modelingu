/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.tag;

import domain.Authority;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.List;
/**
 *
 * @author uniqueblackrose
 */
public class AuthoritiesesTag extends TagSupport{
    private List<Authority> authoritieses;
    private int authorityId;
    private String nameTag;

    public void setNameTag(String name) {
        this.nameTag = name;
    }

    public void setAuthorityId(int authorityid) {
        this.authorityId = authorityid;
    }

    public void setAuthoritieses(List<Authority> authoritieses) {
        this.authoritieses = authoritieses;
    }

    @Override
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            if(this.authoritieses != null) {
                out.print("<select name=\""+ this.nameTag + "\">");
                for(Authority authority : this.authoritieses) {
                    out.print("<option value=\""+ String.valueOf(authority.getId()) +"\"");
                    if(authorityId == authority.getId()) {
                        out.print(" selected=\"selected\"");
                    }
                    out.print(">" + authority.getAuthority() +"</option>");
                }
                out.print("</select>");
            }
        } catch(IOException e) {}

        return(SKIP_BODY);
    }
}
