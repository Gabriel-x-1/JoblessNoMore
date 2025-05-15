package com.example.mvcproducts.domain;

public class SocialLinks {
    private String linkedin;
    private String twitter;
    private String facebook;
    private String github;

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getGithub() {
        return github;
    }

    public SocialLinks(){}
}

