package aut.bme.hu.interactor.profile;


import aut.bme.hu.model.User;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class ProfileDataSavedEvent {
    private User profileData;

    public ProfileDataSavedEvent(User profileData) {
        this.profileData = profileData;
    }

    public User getProfileData() {
        return profileData;
    }

    public void setProfileData(User profileData) {
        this.profileData = profileData;
    }
}
