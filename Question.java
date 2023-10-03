package tp02;

public class Question {
    public String titre;
    public String description;
    public  Reponse[] reponse;
    public int score;

    public Question(String titre,String description,Reponse[] reponse, int score){
        this.titre = titre;
        this.description = description;
        this.reponse = reponse;
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder reponseString = new StringBuilder();
        for (int i=0;i<reponse.length;i++){
            reponseString.append("  ").append(i + 1).append("- ").append(reponse[i]).append("\n");
        }
        return "titre question :"+titre
                +"\ndescription :"+description
                +"\nscore :"+score
                +"\nreponses\n"+reponseString+"\n";
    }
}
