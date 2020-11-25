package org.example.testing_system;

import org.example.testing_system.domain.Quiz;
import org.example.testing_system.service.QuizService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuizService service = context.getBean(QuizService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();
        int rightAnswers = 0;
        List<Quiz> quizzes = service.getAllQuizzes();
        for (Quiz quiz :
                quizzes) {
            System.out.println(quiz.getQuestion());
            int counter = 1;
            for (String option :
                    quiz.getOptions()) {
                System.out.println(counter++ + ". " + option);
            }
            System.out.println("Enter right answer:");
            rightAnswers += scanner.nextInt() == quiz.getAnswer() ? 1 : 0;
        }
        System.out.println(name + " your result is " + rightAnswers + " correct answers out of " + quizzes.size());
    }
}
