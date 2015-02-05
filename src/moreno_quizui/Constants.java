package moreno_quizui;

/**
 * Constants Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-13
 */
public class Constants {

    /**
     * Collection of integer constants used for various components, such as
     * input validation, and menu selection.
     */
    public static final int NO_OPTION_SELECTED = 0;
    public static final int INVALID_SELECTION = -1;
    public static final int MINIMUM_MENU_OPTION = 1;
    public static final int ELEMENT_INDEX = 0;
    public static final int BUILD_QUIZ = 1;
    public static final int TAKE_QUIZ = 2;
    public static final int QUIT_PROGRAM = 3;
    public static final int ADD_FILL_IN_QUESTION = 1;
    public static final int ADD_CHOICE_QUESTION = 2;
    public static final int ADD_NUMERIC_QUESTION = 3;
    public static final int ADD_BOOLEAN_QUESTION = 4;
    public static final int VIEW_QUIZ = 5;
    public static final int RESET_QUIZ = 6;
    public static final int RETURN_TO_MAIN_MENU = 7;
    public static final int QUIT_PROGRAM_IN_BUILD_MENU = 8;
    
    /**
     * This number is used to make comparisons between two numbers. It is set to
     * be approximate to the nearest 1/100th.
     */
    public static final double EPSILON = 1E-2;
    
    /**
     * Collection of String constants in the American English Language.
     */
    public static final String ENTER_QUESTION_TEXT = "Enter question text: ";
    public static final String ENTER_ANSWER = "Enter answer: ";
    public static final String ENTER_OPTION_STRING = "Enter option string (each option delimited with a '|'): ";
    public static final String MAIN_MENU = "\t***MAIN MENU***";
    public static final String MAIN_MENU_SELECTIONS = "Build Quiz|Take Quiz|";
    public static final String BUILD_QUIZ_MENU = "\tBUILD QUIZ MENU";
    public static final String BUILD_QUIZ_MENU_SELECTIONS = "Add Fill-In Question|Add Choice Question|Add Numeric Question|Add Boolean Question|View Quiz|Reset Quiz|Return to Main Menu|";
    public static final String DELIMETER = "|";
    public static final String GOODBYE = "Goodbye!";
    public static final String INVALID_INPUT = "\n***INVALID INPUT***\nEnter number between %d and %d. \n\n";
    public static final String OPTION_FORMAT = "%d - %s\n";
    public static final String QUIZ_OPTION_FORMAT = "\t%c - %s\n";
    public static final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String SELECTION_PROMPT_FORMAT = "Enter a number between %d and %d: ";
    public static final String DIVIDER = "===============================\n";
    public static final String QUIT = "Quit";
    public static final String NEW_LINE = "\n";
    public static final String PROMPT_FLAG = "ARE YOU SURE YOU WANT TO RESET THE QUIZ (y/n)? ";
    public static final String NO_QUIZ_ERROR = "***ERROR: NO QUIZ EXISTS TO TAKE***\n";
    public static final String QUIZ_CLEARED_PROMPT = "***QUIZ HAS BEEN CLEARED***\n\n";
    public static final String QUIZ_NOT_CLEARED_PROMPT = "***QUIZ HAS NOT BEEN CLEARED***\n\n";
    public static final String HYPHEN = " - ";
    public static final String REQUEST_ANSWER = "Enter your answer: ";
    public static final String CORRECT = "\n***CORRECT!***\n";
    public static final String INCORRECT = "\n***INCORRECT!***\n";
    public static final String QUIZ_RESULTS = "You got %d out of %d correct.\n\n";
    public static final String BOOLEAN_SELECTIONS = "True|False|";
}
