package org.example.testing_system.domain;

public class Quiz {
    private String question;
    private String[] options;
    private int answer;

    public Quiz(String question, String[] options, int rightOption) {
        this.question = question;
        this.options = options;
        this.answer = rightOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(question);
        for (int i = 0; i < options.length; i++) {
            sb
                    .append("\n")
                    .append(i + 1)
                    .append(". ")
                    .append(options[i]);
        }

        return sb.toString();
    }
}
