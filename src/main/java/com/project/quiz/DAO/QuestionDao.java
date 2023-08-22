package com.project.quiz.DAO;


import com.project.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question,Integer> {

    public List<Question> findByCategory(String category);

    @Query(value ="SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery=true)
    public List<Question> findRandomQuestionByCategory(String category,int numQ);
}
