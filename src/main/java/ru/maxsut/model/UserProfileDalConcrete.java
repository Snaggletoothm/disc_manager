package ru.maxsut.model;

/**
 * Created by Максим on 11.08.2015.
 */

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import ru.maxsut.domain.User;
import ru.maxsut.domain.UserProfile;

@Service
public class UserProfileDalConcrete extends DAL<Integer, UserProfile> implements UserProfileDal {

    public UserProfile findUserProfileByType(String type) {

        Query query = getSession().createQuery("select up from UserProfile up " +
                "left join fetch up.users u where up.type =:type");
        query.setString("type", type);
        return (UserProfile)query.uniqueResult();
    }

    public void saveUserProfile(UserProfile userProfile) {
        persist(userProfile);
    }
}
