package com.vone.javarest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vone.javarest.entity.CommentEntity;
import com.vone.javarest.repository.CommentRepositrory;
import com.vone.javarest.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepositrory commentRepository;

    public CommentServiceImpl(CommentRepositrory commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentEntity> getAllThreadComments(Long threadId) {
        List<Long> ids = new ArrayList<Long>();
        ids.add(threadId);
        Iterable<Long> iterable = ids;
        return commentRepository.findAllById(iterable);
    }

    @Override
    public Optional<CommentEntity> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public CommentEntity postComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }
    
    @Override
    public CommentEntity updateComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);        
    }
    
}
