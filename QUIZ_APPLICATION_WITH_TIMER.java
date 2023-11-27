import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



    class Question {
        private String questionText;
        private List<String> options;
        private char correctAnswer;

        public Question(String questionText, List<String> options, char correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestionText() {
            return questionText;
        }

        public List<String> getOptions() {
            return options;
        }

        public char getCorrectAnswer() {
            return correctAnswer;
        }
    }

    class Quiz {
        private List<Question> questions;
        private int currentQuestionIndex;
        private int score;
        private Timer timer;

        public Quiz(List<Question> questions) {
            this.questions = questions;
            this.currentQuestionIndex = 0;
            this.score = 0;
        }

        public void start() {
            askQuestion();
        }

        private void askQuestion() {
            if (currentQuestionIndex < questions.size()) {
                Question currentQuestion = questions.get(currentQuestionIndex);

                // Display the question and options
                System.out.println("Question: " + currentQuestion.getQuestionText());
                List<String> options = currentQuestion.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((char) ('A' + i) + ". " + options.get(i));
                }

                // Set up a timer for 30 seconds
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Time's up! Moving to the next question.");
                        nextQuestion();
                    }
                }, 30000); // 30 seconds

                // Allow the user to submit an answer
                System.out.print("Your answer: ");
                Scanner scanner = new Scanner(System.in);
                char userAnswer = scanner.next().toUpperCase().charAt(0);

                // Check the answer
                if (userAnswer == currentQuestion.getCorrectAnswer()) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer is " + currentQuestion.getCorrectAnswer() + ".\n");
                }

                // Move to the next question
                nextQuestion();
            } else {
                endQuiz();
            }
        }

        private void nextQuestion() {
            // Cancel the timer
            timer.cancel();

            // Move to the next question
            currentQuestionIndex++;

            // Ask the next question
            askQuestion();
        }

        private void endQuiz() {
            System.out.println("Quiz ended!");
            System.out.println("Your final score: " + score + " out of " + questions.size());
        }
    }

    public class QUIZ_APPLICATION_WITH_TIMER {
        public static void main(String[] args) {
            // Create quiz questions
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("What is the capital of France?",
                    List.of("Berlin", "Madrid", "Paris", "Rome"), 'C'));
            questions.add(new Question("What is the Capital of Pakistan",
                    List.of("Karachi","Islamabad","Lahore","None"),'B'));
           questions.add(new Question("Who was the 23rd president of the US?",
                   List.of("Abraham lincoln", "George washington","Barack Obama","Benjamin Harrison"),'D'));
            questions.add(new Question("Spinach is high in:",
                    List.of("Vitamin C", "Iron","Biotin","None"),'B'));
            questions.add(new Question("How many months in a year have only 29 days?",
                    List.of("1", "3","4","1, but not every year, but once every 4 years"),'D'));

            Quiz quiz = new Quiz(questions);


            quiz.start();
        }
    }


