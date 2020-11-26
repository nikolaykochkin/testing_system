package org.example.testing_system.application;

import org.example.testing_system.domain.Quiz;
import org.example.testing_system.service.QuizService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class QuizApplicationCLI implements QuizApplication {
    private final QuizService service;
    private final MessageSource messageSource;
    private final Locale locale;

    public QuizApplicationCLI(QuizService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
        locale = Locale.ENGLISH;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                messageSource.getMessage(
                        "message.enter.name",
                        null,
                        locale
                )
        );
        String name = scanner.nextLine();
        System.out.println(
                messageSource.getMessage(
                        "message.out.hello",
                        new String[]{name},
                        locale
                )
        );
        int rightAnswers = 0;
        List<Quiz> quizzes = service.getAllQuizzes();
        for (Quiz quiz :
                quizzes) {
            System.out.println(quiz);
            System.out.println(
                    messageSource.getMessage(
                            "message.enter.answer",
                            null,
                            locale
                    )
            );
            rightAnswers += scanner.nextInt() == quiz.getAnswer() ? 1 : 0;
        }
        System.out.println(
                messageSource.getMessage(
                        "message.out.result",
                        new String[]{name, Integer.toString(rightAnswers), Integer.toString(quizzes.size())},
                        locale
                )
        );
        System.out.println(messageSource.getMessage(
                "message.out.bye",
                new String[]{name},
                locale
        ));
    }
}
