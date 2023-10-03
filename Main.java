package tp02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String titre;
        Question[] questions;
        Questionnaire questionnaire;
        int questionsSize;
        String titreQuestion;
        String descriptionQuestion;
        int scoreQuestion;
        Reponse[] reponsesQuestion;
        int reponsesSize;
        String titreReponse;
        boolean correcteReponse;

        int user_score = 0;
        int user_response;

        Scanner input = new Scanner(System.in);

        //Questionnaire
        System.out.println("[[ saisir un questionnaire ]]");
        System.out.println("Titre questionnaire :");
        titre = input.nextLine();

        //Questions
        System.out.println("[[ saisir les questionnes ]]");
        System.out.println("nombre des questionnes :");
        questionsSize = Integer.parseInt(input.nextLine());

        questions = new Question[questionsSize];

        for (int i = 0; i < questionsSize; i++) {
            System.out.println("[Questionne n: "+(i+1)+"]");
            System.out.println("titre de questionne :");
            titreQuestion = input.nextLine();
            System.out.println("description de questionne :");
            descriptionQuestion = input.nextLine();
            System.out.println("score de questionne :");
            scoreQuestion = Integer.parseInt(input.nextLine());

            //Responses
            System.out.println("[[ saisir les reponses ]]");
            System.out.println("nombre des reponses : ");
            reponsesSize = Integer.parseInt(input.nextLine());

            reponsesQuestion = new Reponse[reponsesSize];

            for (int j = 0; j < reponsesSize; j++) {
                System.out.println("[reponse n: "+(j+1)+"]");
                System.out.println("Titre de reponse :");
                titreReponse = input.nextLine();
                System.out.println("correcte :");
                correcteReponse = Boolean.parseBoolean(input.nextLine());
                reponsesQuestion[j] = new Reponse(titreReponse,correcteReponse);
            }

            questions[i] = new Question(titreQuestion,descriptionQuestion,reponsesQuestion,scoreQuestion);

        }
        questionnaire = new Questionnaire(titre,questions);

        // display questions
        for (int i = 0; i < questionsSize; i++) {
            System.out.println("\n[ questions "+(i+1)+" ]\n"+questions[i].titre+"\n"
                    +questions[i].description+"\nscore "
                    +questions[i].score+"\n\nreponses :");
            for (int j = 0; j<questions[i].reponse.length ;j++) {
                System.out.println((j+1)+"- "+questions[i].reponse[j].titre);
            }
            System.out.println("\nvotre reponse :");
            user_response = Integer.parseInt(input.nextLine());
            if (questions[i].reponse[user_response-1].correcte)
                user_score += questions[i].score;
        }

        // results
        System.out.println("______________________________");
        System.out.println("\nvotre score final: "+user_score);
        System.out.println("______________________________");

        // correct answers
        for (int i = 0; i < questionsSize; i++) {
            System.out.println("\n[ questions "+(i+1)+" ]\n"+questions[i].titre+"\n" +
                    "\ncorrect reponses :");
            for (int j = 0; j<questions[i].reponse.length ;j++) {
                if (questions[i].reponse[j].correcte)
                    System.out.println(questions[i].reponse[j].titre);
            }
        }

    }
}
