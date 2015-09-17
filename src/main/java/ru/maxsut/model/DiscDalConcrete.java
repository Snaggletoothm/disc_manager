package ru.maxsut.model;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxsut.domain.Comment;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;

import java.util.List;
import java.util.Set;

@Service
public class DiscDalConcrete extends DAL<Integer, Disc> implements DiscDal {

    @Autowired
    UserDal userDal;

    public List<Disc> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Disc>)criteria.list();
    }

    public List<Disc> findAllWithDetails() {
        Query query = getSession()
                .createQuery("select distinct d from Disc d left join fetch d.user");
        return query.list();
    }

    public Comment findCommentById(int id) {
        Query query = getSession().createQuery("select c from Comment c where c.id =:id");
        query.setInteger("id", id);
        return (Comment)query.uniqueResult();
    }

    public List<Disc> getFreeDiscs() {
        Query query = getSession().createQuery("select d from Disc d left join fetch d.user u " +
                "where d.owner = 1 " +
                "order by d.title, u.name");
        return query.list();
    }

    public Disc findFreeDiscById(int id) {
        Query query = getSession().createQuery(
                "select d from Disc d " +
                "left join fetch d.user u " +
                "left join fetch d.comments c " +
                "where d.owner =:owner and d.id =:id " +
                "order by c.localDate");
        query.setInteger("owner", 1);
        query.setInteger("id", id);
        return (Disc)query.uniqueResult();
    }

    public List<Disc> getHiredDiscsByUserName(String name) {
        String hql = "select d from Disc d " +
                        "left join fetch d.user u " +
                        "where tempOwnerName =:name and owner = 0 " +
                        "order by d.title, u.name";
        Query query = getSession().createQuery(hql);
        query.setString("name", name);
        return query.list();
    }

    public List<Disc> getGivenDiscsByUserName(String name) {
        User user = userDal.findUserByName(name);
        Query query = getSession().createQuery("select d from Disc d " +
                "left join fetch d.user u " +
                "where u.id =:id and d.owner =:owner " +
                "order by d.title, u.name");
        query.setInteger("id", user.getId());
        query.setInteger("owner", 0);
        return query.list();
    }

    public List<Disc> findAllDiscsByOwnerName(String name) {
        Query query = getSession().createQuery("select d from Disc d " +
               "left join fetch d.user u " +
               "where u.name =:name");
        query.setString("name", name);
        return query.list();
    }

    public Disc findByTitle(String title) {
        Query query = getSession().createQuery("select d from Disc d where d.title =:title " +
                "order by d.title");
        query.setString("title", title);
        return (Disc)query.uniqueResult();
    }

    public Disc findById(int id) {
        Query query = getSession().createQuery("select d from Disc d " +
                "left join fetch d.user u " +
                "where d.id =:id " +
                "order by d.title, u.name");
        query.setInteger("id", id);
        return (Disc)query.uniqueResult();
    }

    public void saveDisc(Disc disc) {
        persist(disc);
    }

    public void saveCommentForDisc(Comment comment, int discId) {
        Query query = getSession().createSQLQuery("INSERT INTO comment " +
                "(disc_id, user_name, user_comment, local_date) VALUES " +
                "(:discId, :userName, :userComment, CURRENT_DATE)" );
        query.setInteger("discId", discId);
        query.setString("userName", comment.getUserName());
        query.setString("userComment", comment.getUserComment());
        query.executeUpdate();
    }

    public void deleteComment(int id) {
        Comment comment = findCommentById(id);
        getSession().delete(comment);
    }

    public void deleteDisc(Disc disc) {
        delete(disc);
    }

    public void updateDisc(Disc disc) {
        update(disc);
    }

    public void moveDisc(String currUserName, int discId) {
        Disc disc = this.findById(discId);
        Query query;

        if(disc.getTempOwnerName().equals("")){
            query = getSession()
                    .createQuery("update Disc d " +
                            "set d.tempOwnerName =:name, d.owner = 0 " +
                            "where d.id =:id");
            query.setString("name", currUserName);
            query.setInteger("id", discId);
        }else{
            query = getSession()
                    .createQuery("update Disc d " +
                            "set d.tempOwnerName ='', d.owner = 1 " +
                            "where d.id =:id");
            query.setInteger("id", discId);
        }
        query.executeUpdate();
    }


    public int ownDiscAmountByUserName(String name) {
        String hql = "select d from Disc d " +
                        "left join fetch d.user u " +
                        "where u.name =:name and d.owner =:owner";
        Query query = getSession().createQuery(hql);
        query.setString("name", name);
        query.setInteger("owner", 1);
        return query.list().size();
    }

    public int hiredDiscAmountByUserName(String name) {
        String hql = "select d from Disc d " +
                        "left join fetch d.user u " +
                        "where d.tempOwnerName =:name";
        Query query = getSession().createQuery(hql);
        query.setString("name", name);
        return query.list().size();
    }
}
