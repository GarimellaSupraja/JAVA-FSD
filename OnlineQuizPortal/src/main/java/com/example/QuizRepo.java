package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface QuizRepo extends JpaRepository<Quizz, Integer> {

		public List<Quizz> findByQuizid(int quizid);
}
