package data.repositories;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);
    long countComment();
    Comment findById(int id);
    List<Comment> findAll();
//    void delete(Comment comment);
    void delete(int id);

    void deleteAll();
}
