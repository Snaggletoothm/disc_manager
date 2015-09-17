package ru.maxsut.service;

import org.hibernate.Criteria;
import org.hibernate.Query;
import ru.maxsut.domain.Comment;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;
import ru.maxsut.domain.UserProfile;

import java.util.List;

public interface CustomService {
    List<Disc> findAllDiscs();
    List<Disc> findAllDiscsWithDetails();
    List<Disc> getFreeDiscs();
    List<Disc> getHiredDiscsByUserName(String name);
    List<Disc> getGivenDiscsByUserName(String name);
    List<Disc>  findAllDiscsByOwnerName(String name);

    Disc findDiscByTitle(String title);
    Disc findDiscById(int id);
    Disc findFreeDiscById(int id);
    Comment findCommentById(int id);

    void saveDisc(Disc disc);
    void saveCommentForDisc(Comment comment, int discId);
    void deleteDisc(Disc disc);
    void updateDisc(Disc disc);
    void moveDisc(String currUserName, int discId);
    void deleteComment(int id);

    List<User> findAllUser();
    List<User> findAllUsersWithDetails();
    User findUserByName(String name);
    User findUserById(int id);
    void saveUser(User user);
    void deleteUser(User user);
    void updateUser(User user);

    UserProfile findUserProfileByType(String type);
    void saveUserProfile(UserProfile userProfile);

    int ownDiscAmountByUserName(String name);
    int hiredDiscAmountByUserName(String name);
}
