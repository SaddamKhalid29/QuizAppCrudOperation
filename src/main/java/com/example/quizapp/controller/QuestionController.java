package com.example.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.QuestionService;

@RestController
@RequestMapping("question") 		//Request url on the browser
public class QuestionController {
	
	@Autowired			//Hanlde the object things		
	QuestionService questionService;
	
	@GetMapping("allquestions")		//Request url for specific
	public List<Question> getAllQuestions() {
		
		return questionService.getAllQuestions();
		
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionByType(@PathVariable String category){
		
		return questionService.getQuestionByType(category);
	}
	
	@GetMapping("id/{id}")
	public Optional<Question> getQuestionById(@PathVariable Integer id) {
		return questionService.getQuestionById(id);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Question question) {
		Question newQuestion = questionService.addQuestion(question);
		return "Question with id "+ newQuestion.getId()+ " Added Successfully!";
		
	}
	@PutMapping("update/{id}")
	public String updateQuestion(@PathVariable int  id,  @RequestBody Question updatedQuestion) {
		Optional<Question> prevQues = getQuestionById(id);
	    
		if (prevQues.isPresent()) {
	        Question prevQuest = prevQues.get();
	        
	        // Update fields as necessary
	        prevQuest.setQuestionTitle(updatedQuestion.getQuestionTitle());
	        prevQuest.setOption1(updatedQuestion.getOption1());
	        prevQuest.setOption2(updatedQuestion.getOption2());
	        prevQuest.setOption3(updatedQuestion.getOption3());
	        prevQuest.setOption4(updatedQuestion.getOption4());
	        prevQuest.setRightAnswer(updatedQuestion.getRightAnswer());
	        prevQuest.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
	        prevQuest.setCategory(updatedQuestion.getCategory());

	        // Save updated question
	        questionService.updateQuestion(prevQuest);
	        
	        return "Question with ID " + id + " updated successfully!";
	    } else {
	        return "No question with ID " + id + " was found!";
	    }
	
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestionById(@PathVariable int id) {
		Optional<Question> quest = getQuestionById(id);
		if(quest.isPresent()) {
			questionService.deleteQuestionById(id);

			return "Deletion is successfull!";
		}else
			return "No Question with this id exist!";
		
		
	}
}