package dev.ogabek.recyclerview5_recyclerviewinsiderecyclerview.model;

import java.util.List;

public class Member {

    private String fullName;
    private String telephoneNumber;
    private List<MemberSub> memberSubs;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public String getFullName() {
        return fullName;
    }
    public List<MemberSub> getMemberSubs() {
        return memberSubs;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setMemberSubs(List<MemberSub> memberSubs) {
        this.memberSubs = memberSubs;
    }

    public Member(String fullName, String telephoneNumber, List<MemberSub> memberSubs) {
        this.fullName = fullName;
        this.telephoneNumber = telephoneNumber;
        this.memberSubs = memberSubs;
    }

    public Member() {}

}
