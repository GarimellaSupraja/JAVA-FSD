package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionsService {
	
	
	@Autowired
	private QuestionsRepo repo;
	
	@Autowired
	private QuizRepo repo1;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public String adminSignIn(User user) {
		Optional<User> op=userRepo.findById(user.getName());
		if(op.isPresent()) {
		User l=op.get();
			if(l.getName().equals(user.getName())&&l.getPassword().equals(user.getPassword())) {
				System.out.println("success");
				return "Admin Login Succesfully";
			}
			else {
			 //update existing records
			return "failure";
			}
		}else {
			return "record not present";
		}
	}
	
	
	
	//add method or CREATE RECORD
	public Questions addQuestion(Questions q) {
		// TODO Auto-generated method stub
		return repo.save(q);
	}

	//get all questions
	public List<Questions> getAllQuestion() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

		//delete Question
	public boolean deleteQuestion(int id) {

			if(repo.findById(id).isPresent())
			{
				repo.deleteById(id);
				return true;
			}
			else
				return false;
		}

	public Questions getQuestionById(int id) {
		if(repo.findById(id).isPresent()) 
			return repo.findById(id).get();
		else 
			return null;
	}
	
	//creating quizz
	public Quizz addQuiz(Quizz q) {
		// TODO Auto-generated method stub
		return repo1.save(q);
	}
	
	public String changePassword(User user) {
		Optional<User> op=userRepo.findById(user.getName());
		if(op.isPresent()) {
			User l=op.get();
			if(l.getPassword().equals(user.getPassword())) {
				return "record updation failure";
			}
			else {
			l.setPassword(user.getPassword());
			userRepo.saveAndFlush(l);    //update existing records
			return "Record updated successfully";
			}
		}else {
			 //employeeRepository.save(emp);
			 return "Record not present";
		}
	}
}