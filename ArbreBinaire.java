import java.util.Stack;

public class ArbreBinaire {
    Noeud racine;
    Stack<Noeud> pile;
    // Constants auxiliaires pour affichage
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    // Classe auxiliaire Noeud
    class Noeud {
        char valeur;
        Noeud noeudGauche = null;
        Noeud noeudDroite = null;
        public Noeud(char valeur) {
            this.valeur = valeur;
        }

        public String toString() {
            char d = (this.noeudDroite != null ? this.noeudDroite.valeur : ' ');
            char g = (this.noeudGauche != null ? this.noeudGauche.valeur : ' ');
            String s = ANSI_RED+"\nNoeud: "+this.valeur + ANSI_YELLOW + " FILSG: "+ g + ANSI_GREEN + " FILSD: "+ d + ANSI_RESET;
            return s;

        }
    }
    // Méthodes utilisés aux réponses
    public void construireArbrePos(char[] seq) {
        /*
            Explication :Nous allons parcourir les éléments de la seq de chars, s'il s'agit d'un
            élément du type (+, -, /, *) nous allons 'pop' les deux derniers éléments de la pile et les ajouterons 
            comme sous-noeuds du nouvel élément (puis on 'push' cet élément). S'il s'agit d'un nombre, on l'ajoutera à la pile. 
        */
        Noeud aux1, aux2, aux3;
        this.pile = new Stack<Noeud>();
        for(int i=0; i<seq.length; i++){
            if (!estOperande(seq[i])){
                aux1 = new Noeud(seq[i]); // Un numéro comme 2, 3, 4, etc.
                pile.push(aux1);
                System.out.println(aux1);
            }else {
                aux1 = new Noeud(seq[i]); // Un opérateur comme +, -, *
                aux2 = pile.pop(); // opérand 1
                aux3 = pile.pop(); // opérand 2

                aux1.noeudDroite = aux2;
                aux1.noeudGauche = aux3;

                pile.push(aux1);
                System.out.println(aux1);
            }
        }
        this.racine = pile.peek();
    }
    private boolean estOperande(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }
    // Réponses aux exercices
    public void exo1(){
        printMessage("\n\nExercice 6.1\nR:", ANSI_BLUE);
        printMessage(" Notation Polonaise inverse correspond au parcours postfixe de l'arbre binaire. ", ANSI_WHITE);
    }

    public void exo2(){
        printMessage("\n\nExercice 6.2\nR:", ANSI_BLUE);
        String charSeq = "26*51-+";
        construireArbrePos(charSeq.toCharArray());

        // construireArbrePos(['+']);
        
    }
    // Méthodes auxiliaires
    public static void printMessage(String m, String color) {
        System.out.print(color+m+ANSI_RESET);
    }

    // Main
    public static void main(String[] args) {
        ArbreBinaire ab = new ArbreBinaire();
        ab.exo1();
        ab.exo2();
    }
}