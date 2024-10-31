package com.example.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}
	public List<Question> getQuestionByType(String category) {
		
		return questionDao.findByCategory(category);
	}
	public Optional<Question> getQuestionById(int id) {
		// TODO Auto-generated method stub
		return questionDao.findById(id);
	}
	
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDao.save(question);
	}
	public Question updateQuestion(Question prevQuest) {
		// TODO Auto-generated method stub
		return questionDao.save(prevQuest);
		
	}
	public void deleteQuestionById(int id) {
		// TODO Auto-generated method stub
		questionDao.deleteById(id);
		
	}
	

}
