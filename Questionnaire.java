package tp02;

public class Questionnaire {
    public String titre;
    public Question[] question;

    public Questionnaire(String titre, Question[] question) {
        this.titre = titre;
        this.question = question;
    }

    @Override
    public String toString() {
        StringBuilder questionString = new StringBuilder();
        for (Question question:question){
            questionString.append(question);
        }
        return "Titre questionnaire :"+titre
                +"\n[List of Questiones]\n\n"+questionString;
    }
}
