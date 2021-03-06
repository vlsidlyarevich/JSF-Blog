package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.repository;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vlad on 22.08.16.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT c FROM Comment c WHERE c.id = ?1")
    Comment findOneCommentById(Long id);

    @Query(value = "SELECT c FROM Comment c WHERE c.postId = ?1")
    List<Comment> findAllCommentsFromPostById(Long id);

    @Modifying
    @Query(value = "UPDATE Comment c SET c.review = ?1 WHERE c.id = ?2")
    void updateReviewById(String review, Long id);

    @Modifying
    @Query(value = "DELETE FROM Comment c WHERE c.id = ?1")
    void delete(Long id);
}
