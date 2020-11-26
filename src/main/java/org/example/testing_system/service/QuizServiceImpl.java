package org.example.testing_system.service;

import org.example.testing_system.dao.QuizDao;
import org.example.testing_system.domain.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizDao dao;

    public QuizServiceImpl(QuizDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return dao.getQuizzes();
    }
}
