class CutAway {
    public static void main(String [] args) {

        int[][] m = { 	{1, 2, 3, 4, 5, 6, 7},
                {8, 9, 0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9, 0, 1, 3, 4},
                {},
                {2, 3, 4, 5, 6, 7, 8},
                null,
                {9, 0, 1, 2, 3, 4, 5}};

        Out.print("\nAusgangs-Matrize");
        Out.print("\n----------------");
        print(m);

        Out.print("\nWie viel soll abgeschnitten werden: ");
        int cutAway = In.readInt();

        Out.print("\n\n   ... cut away " + cutAway + "\n");
        int[][] c = cutAway(m, cutAway);


        Out.print("\nBeschnittene-Matrize");
        Out.print("\n-------------------");
        print(c);

    } // end main()

    // cutAway() ----------------------------------------------------------------------
    static int[][] cutAway(int[][] m, int cutAway) {if (m == null) return null;
        int[][] result = new int [m.length][];
        int length;

        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                if (m[i].length-cutAway >= 0) {
                    length = m[i].length-cutAway;
                } else {
                    length = 0;
                }
                int[] row = new int[length];

                for (int j = 0; (j < length); j++) {
                    row[j] = m[i][j];
                }
                result[i] = row;
            }
        }
        return result;
    } // end cutAway()

    static void print(int[][] m) {
        if (m == null) return;

        for (int i = 0; i < m.length; i++) {
            Out.print("\n");

            if (m[i] == null) {
                Out.print("-null-");
            } else {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.printf("%3d " , m[i][j]);
                }
            }
        }
    }
} // end CutAway