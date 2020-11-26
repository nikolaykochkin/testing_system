package org.example.testing_system.dao;

import org.example.testing_system.domain.Quiz;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuizDaoFromCSV implements QuizDao {

    private String filePath;
    private List<Quiz> quizzes;


    public QuizDaoFromCSV(@Value("${dao.file}") String filePath) {
        this.filePath = filePath;
        quizzes = new ArrayList<>();
        parseFile();
    }

    private void parseFile() {
        int QUESTION = 0;
        int ANSWER = 1;
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            List<String> lines = Files.readAllLines(Paths.get(classLoader.getResource(filePath).toURI()));
            for (String line : lines) {
                String[] info = line.split(",");
                quizzes.add(
                        new Quiz(
                                info[QUESTION],
                                Arrays.copyOfRange(info, 2, info.length),
                                Integer.parseInt(info[ANSWER].trim())
                        )
                );
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quiz> getQuizzes() {
        return quizzes;
    }
}
