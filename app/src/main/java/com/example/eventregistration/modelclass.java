package com.example.eventregistration;

public class modelclass {
    String firstname,lastname,email,phonenumber,selectedtextview
        ,website,bio,github,twitter,radiogroup,dropdown1,dropdown2;

    public modelclass() {
    }

    public modelclass(String firstname, String lastname, String email, String phonenumber
            ,String selectedtextview, String website, String bio, String github,
                      String twitter,String radiogroup,String dropdown1,String dropdown2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.selectedtextview=selectedtextview;
        this.website = website;
        this.bio = bio;
        this.github = github;
        this.twitter = twitter;
        this.radiogroup=radiogroup;
        this.dropdown1=dropdown1;
        this.dropdown2=dropdown2;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSelectedtextview() {
        return selectedtextview;
    }

    public void setSelectedtextview(String selectedtextview) {
        this.selectedtextview = selectedtextview;
    }



    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getRadiogroup() {
        return radiogroup;
    }

    public void setRadiogroup(String radiogroup) {
        this.radiogroup= radiogroup;
    }

    public String getDropdown1() {
        return dropdown1;
    }

    public void setDropdown1(String dropdown1) {
        this.dropdown1 = dropdown1;
    }

    public String getDropdown2() {
        return dropdown2;
    }

    public void setDropdown2(String dropdown2) {
        this.dropdown2 = dropdown2;
    }
}
