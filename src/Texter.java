class Texter {
    public static void main(String [] args) {

        Out.print("\nTexter");
        Out.print("\n======\n");

        // Unsere Texte
        char [] text1 = {'x','x','H','U', 'G', 'O',
                'H','U', 'G', 'O', 'x',
                'H','U', 'G', 'O', 'x', 'x'};
        char [] text2 = {'x','x','H', 'U', 'G', 'O'};
        char [] search = {'H','U', 'G', 'O'};
        char [] replace = {'h','u', 'g', 'o'};

        // Suchen des Textes - (A)
        int from = 3;
        int atPos = 0;
        Out.print("\nSuche nach ");
        printText(search);
        Out.print("\n in ");
        printText(text1);
        Out.print(" ab Postion " + from);
        Out.print(" => ");
        atPos = find(text1, search, from);
        if (atPos>=0) Out.print("gefunden auf Position "+atPos);
        else Out.print("nicht gefunden!");

        Out.print("\n in ");
        printText(text2);
        Out.print(" ab Postion " + from);
        Out.print(" => ");
        atPos = find(text2, search, from);
        if (atPos>=0) Out.print("gefunden auf Position "+atPos);
        else Out.print("nicht gefunden!");

        // Wie oft im Text? - (B)
        Out.print("\nWie oft kommt ");
        printText(search);
        Out.print("\n in ");
        printText(text1);
        Out.print(" vor ");
        Out.print(" => ");
        int timesFound = howOften(text1, search);
        if (timesFound>=0) Out.print(timesFound + "x gefunden");
        else Out.print("nicht gefunden!");

        Out.print("\nWie oft kommt ");
        printText(search);
        Out.print("\n in ");
        printText(text2);
        Out.print(" vor ");
        Out.print(" => ");
        timesFound = howOften(text2, search);
        if (timesFound>=0) Out.print(timesFound + "x gefunden");
        else Out.print("nicht gefunden!");

        // Ersetzen des Texts - (C)
        Out.print("\nErsetze erstes Auftrenen von ");
        printText(search);
        Out.print("\n in ");
        printText(text1);
        Out.print(" durch ");
        printText(replace);
        char[] replaced = replace(text1, search, replace);
        if (replaced != null) {
            Out.print(" => ");
            printText(replaced);
        }
        else Out.print("nicht gefunden!");


    } // main()

    static void printText(char[] t) {
        if (t == null) return;
        for(int i = 0; i < t.length; i++) {
            Out.print(t[i]);
        }
    } // printText()

    static int find(char[] text, char[] searchText, int fromPos){ // test again but looks like its working
        if(text == null || searchText == null || searchText.length == 0 || text.length == 0 || fromPos > text.length){
            return -1;
        }

        int counter = 0;
        int position = 0;

        for(int i = fromPos; i < text.length; i++){
            if(counter < searchText.length){
                if(text[i] == searchText[counter]){
                    counter ++;
                    if(position == 0){
                        position = i;
                    }
                }
            }
        }
        if(counter == searchText.length){
            return position;
        }
        return -1;
    }

    static int howOften(char[] text, char [] searchText){
        if(text == null || searchText == null || text.length == 0 || searchText.length == 0){
            return -1;
        }

        int counter = 0;
        int textFound = 0;

        for(int i = 0; i < text.length; i++){
            if(counter < searchText.length){
                if(text[i] == searchText[counter]){
                    counter++;
                    if(counter == searchText.length){
                        counter = 0;
                        textFound ++;
                    }
                }
            }
        }
        if(textFound > 0){
            return textFound;
        }
        return -1;
    }

    static char[] replace(char[] text, char[] search, char[] replacement){
        if (text == null || search == null || replacement == null) return null;
        if (text.length == 0 || search.length == 0 || replacement.length == 0) return null;

        return null;
    }







} // end Texter

