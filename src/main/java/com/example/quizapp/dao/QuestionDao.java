package com.example.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	//Table name is Question and Primary key type is Integer
	
	List<Question>findByCategory(String category);

}
