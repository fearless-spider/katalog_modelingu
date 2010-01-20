/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package web.tag;

import domain.Grupa;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.List;
/**
 *
 * @author uniqueblackrose
 */
public class GroupsTag extends TagSupport{
    private List<Grupa> groups;
    private int groupId;
    private String nameTag;

    public void setNameTag(String name) {
        this.nameTag = name;
    }

    public void setGroupId(int groupid) {
        this.groupId = groupid;
    }

    public void setGroups(List<Grupa> groups) {
        this.groups = groups;
    }

    @Override
    public int doStartTag() {
        try {
            JspWriter out = pageContext.getOut();
            if(this.groups != null) {
                out.print("<select name=\""+ this.nameTag + "\">");
                for(Grupa group : this.groups) {
                    out.print("<option value=\""+ String.valueOf(group.getId()) +"\"");
                    if(groupId == group.getId()) {
                        out.print(" selected=\"selected\"");
                    }
                    out.print(">" + group.getName() +"</option>");
                }
                out.print("</select>");
            }
        } catch(IOException e) {}

        return(SKIP_BODY);
    }

}
