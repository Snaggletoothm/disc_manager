package ru.maxsut.model;

import ru.maxsut.domain.Comment;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;

import java.util.List;
import java.util.Set;

public interface DiscDal {
    List<Disc> findAll();
    List<Disc> findAllWithDetails();
    Comment findCommentById(int id);
    List<Disc> getFreeDiscs();
    List<Disc> getHiredDiscsByUserName(String name);
    List<Disc> getGivenDiscsByUserName(String name);
    List<Disc>  findAllDiscsByOwnerName(String name);

    Disc findByTitle(String name);
    Disc findById(int id);
    Disc findFreeDiscById(int id);

    void saveDisc(Disc disc);
    void saveCommentForDisc(Comment comment, int discId);
    void deleteComment(int id);
    void deleteDisc(Disc disc);
    void updateDisc(Disc disc);

    void moveDisc(String currUserName, int discId);

    int ownDiscAmountByUserName(String name);
    int hiredDiscAmountByUserName(String name);
}
