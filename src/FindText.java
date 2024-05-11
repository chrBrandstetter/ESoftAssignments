class FindText {
    public static void main(String [] args) {
        char[][] texts = {{'a','b','c','d','H','e','f','g','x'},
                {'h','i','j','k','l','U','m','n','a','b'},
                {'o','p','q','r','s','t','G','u'},
                {'v','w','x','y','z','a','b','O','y'},
                {},
                null};

        char[] search = {'H','U','G','O'};

        Out.print("\nText:\n--------------------------------\n");
        print(texts);
        Out.print("\n--------------------------------\n");
        print(search);

        if (findText(texts, search)) {
            Out.print("\nkommt vor!");
        } else {
            Out.print("\nkommt nicht vor!");
        }

    } // end main


    static boolean findText(char[][] texts, char[] searchText) {if(texts == null) return false;
        if(searchText == null) return false;
        int seachResult = 0;
        int savepos = 0;
        int offset = 0;

        for (int i = 0; i < texts.length && i < searchText.length; i++) {
            if (texts[i] != null) {
                while (seachResult == 0) {
                    for (int j = 0; j < texts[i + offset].length; j++) {
                        if (texts[i + offset][j] == searchText[i]) {
                            seachResult = 1;
                            savepos = j + 1;
                        }
                    }
                    if (seachResult == 0) {
                        offset++;
                    }
                }
                if ((savepos < texts[i].length) && (texts[i + offset][savepos] == searchText[i])) {
                    seachResult++;
                    savepos++;
                }
            }
        }

        if (seachResult == searchText.length){
            return true;
        } else {
            return false;
        }
    } // end findText()

    static void print(char[][] texts) {
        if (texts == null) return;
        for (int i = 0; i < texts.length; i++) {
            if (texts[i] != null) print(texts[i]);
            Out.print("\n");
        }
    } // end  printTexts()

    static void print(char [] text) {
        if (text == null) return;
        for (int i = 0; i < text.length; i++) {
            Out.print(text[i]);
        }
    } // end printText()

} // end class FindText