public class hw0 {
    public static void main(String[] args) {
        StarString(5);
        PrintInd("ABC");
        Stutter("ABC");
        String quad = Integer.toString(Quadrant(0, 0));
        System.out.println(quad);
    }

    public static void StarString(int n) {

        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < i + 1; j++) {
                line += "*";
            }
            System.out.println(line);
        }
    }

    public static void PrintInd(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            output += s.charAt(i);
            String idx = Integer.toString(s.length() - 1 - i);
            output += idx;
        }
        System.out.println(output);
    }

    public static void Stutter(String s) {
        String output = "";
        for (int i = 0; i < s.length(); i++) {
            output += "" + s.charAt(i) + s.charAt(i);
        }
        System.out.println(output);
    }

    public static int Quadrant(double x, double y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (y > 0 && x > 0) {
            return 1;
        } else if (y > 0 && x < 0) {
            return 2;
        } else if (y < 0 && x < 0) {
            return 3;
        } else {
            return 4;
        }
    }
}