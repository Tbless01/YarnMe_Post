package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    private CommentRepository commentRepository;
    private Comment comment;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
        comment = new Comment();
        comment.setComment("What a funny post ");
    }

    @Test
    public void saveOneComment_countCommentIsOneTest() {
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1, commentRepository.countComment());
    }

    @Test
    public void saveOneComment_idOfCommentIsOneTest() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
    }
    @DisplayName("Update Comment test")
    @Test
    public void saveTwoComment_idOfUserIsOneTest() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.countComment());
        savedComment.setComment("Na wa for these people oo");
        commentRepository.save(savedComment);
        assertEquals(1, commentRepository.countComment());
    }

    @Test
    public void saveOneComment_deleteOneComment_countThatCommentIsNowZeroTest() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.countComment());
    }
}