package ru.maxsut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxsut.domain.Comment;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;
import ru.maxsut.domain.UserProfile;
import ru.maxsut.model.DiscDal;
import ru.maxsut.model.UserDal;
import ru.maxsut.model.UserProfileDal;

import java.util.List;

@Service
@Transactional
public class CustomServiceConcrete implements CustomService {

    @Autowired
    private UserDal userDal;

    @Autowired
    private DiscDal discDal;

    @Autowired
    private UserProfileDal userProfileDal;


    public List<Disc> findAllDiscs() {
        return discDal.findAll();
    }

    public List<Disc> findAllDiscsWithDetails() {
        return discDal.findAllWithDetails();
    }

    public List<Disc> getFreeDiscs() {
        return discDal.getFreeDiscs();
    }

    public List<Disc> getHiredDiscsByUserName(String name) {
        return discDal.getHiredDiscsByUserName(name);
    }

    public List<Disc> getGivenDiscsByUserName(String name) {
        return discDal.getGivenDiscsByUserName(name);
    }

    public List<Disc> findAllDiscsByOwnerName(String name) {
        return discDal.findAllDiscsByOwnerName(name);
    }

    public Disc findDiscByTitle(String title) {
        return discDal.findByTitle(title);
    }

    public Disc findDiscById(int id) {
        return discDal.findById(id);
    }

    public Disc findFreeDiscById(int id) {
        return discDal.findFreeDiscById(id);
    }

    public Comment findCommentById(int id) {
        return discDal.findCommentById(id);
    }

    public void saveDisc(Disc disc) {
        discDal.saveDisc(disc);
    }

    public void saveCommentForDisc(Comment comment, int discId) {
        discDal.saveCommentForDisc(comment, discId);
    }

    public void deleteDisc(Disc disc) {
        discDal.deleteDisc(disc);
    }

    public void updateDisc(Disc disc) {
        discDal.updateDisc(disc);
    }

    public void moveDisc(String currUserName, int discId) {
        discDal.moveDisc(currUserName, discId);
    }

    public void deleteComment(int id) {
        discDal.deleteComment(id);
    }

    public int ownDiscAmountByUserName(String name) {
        return discDal.ownDiscAmountByUserName(name);
    }

    public int hiredDiscAmountByUserName(String name) {
        return discDal.hiredDiscAmountByUserName(name);
    }

    public List<User> findAllUser() {
        return userDal.findAllUsers();
    }

    public List<User> findAllUsersWithDetails() {
        return userDal.findAllUsersWithDetails();
    }

    public User findUserByName(String name) {
        return userDal.findUserByName(name);
    }

    public User findUserById(int id) {
        return userDal.findUserById(id);
    }

    public void saveUser(User user) {
        userDal.saveUser(user);
    }

    public void deleteUser(User user) {
        userDal.deleteUser(user);
    }

    public void updateUser(User user) {
        userDal.updateUser(user);
    }

    public UserProfile findUserProfileByType(String type) {
        return userProfileDal.findUserProfileByType(type);
    }

    public void saveUserProfile(UserProfile userProfile) {
        userProfileDal.saveUserProfile(userProfile);
    }

}
