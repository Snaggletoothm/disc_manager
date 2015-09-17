package ru.maxsut.model;

import ru.maxsut.domain.UserProfile;

/**
 * Created by Максим on 11.08.2015.
 */
public interface UserProfileDal {

    UserProfile findUserProfileByType(String type);
    void saveUserProfile(UserProfile userProfile);
}
