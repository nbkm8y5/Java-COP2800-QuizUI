package moreno_quizui;

/**
 * Choice Question Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014
 * Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-17
 */
public class ChoiceQuestion extends Question {

    private String optionString = "";

    /**
     * ChoiceQuestion Constructor. Initialized with three String arguments, two
     * of which are from superclass Question.
     *
     * @param question This argument collects a String of a question.
     * @param optionString This argument collects a String of delimited answers.
     * @param answer This argument collects the answer to be used in the quiz.
     */
    public ChoiceQuestion(String question, String optionString, String answer) {
        super(question, answer);
        this.optionString = optionString;
    }
}
