package no.frodo.moap.web;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import no.frodo.moap.domain.Member;
import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class MemberView implements Serializable {

    private Member member = new Member();

    private boolean skip;

    public Member getMember() {
        return member;
    }

    public void setMember(Member user) {
        this.member = user;
    }

    public void save() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + member.getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
