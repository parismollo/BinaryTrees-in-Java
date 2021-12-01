public class ArbreBinaire {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {
        exo1();
    }

    public static void exo1(){
        printMessage("\n\nExercice 6.1\nR:", ANSI_BLUE);
        printMessage(" Notation Polonaise inverse correspond au parcours prexife de l'arbre binaire. ", ANSI_WHITE);
    }
    public static void printMessage(String m, String color) {
        System.out.print(color+m+ANSI_RESET);
    }
}