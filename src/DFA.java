import java.io.*;
import java.util.*;

class DFA {
    public static void main(String ar[]) throws FileNotFoundException {
        StringTokenizer st;
        Scanner sc = new Scanner(new File("Input.txt"));

        //number of states
        int noOfStates = sc.nextInt();

        //name of states
        char states[] = new char[noOfStates];
        sc.nextLine();
        st = new StringTokenizer(sc.nextLine());
        int num = 0;
        while (st.hasMoreTokens()) {
            states[num++] = st.nextToken().charAt(0);
        }

        //number of variables
        int varSize = sc.nextInt();
        sc.nextLine();

        //variables
        char variables[] = new char[varSize];
        st = new StringTokenizer(sc.nextLine());
        num = 0;
        while (st.hasMoreTokens()) {
            variables[num++] = st.nextToken().charAt(0);
        }

        //transition of states
        int table[][] = new int[noOfStates][varSize];
        for (int i = 0; i < noOfStates; i++) {
            st = new StringTokenizer(sc.nextLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                char ch = st.nextToken().charAt(0);
                int k;
                for (k = 0; k < noOfStates; k++) {
                    if (states[k] == ch)
                        break;
                }
                table[i][j++] = k;
            }
        }

        //start state
        char startState = sc.nextLine().charAt(0);
        int x = -1;
        for (int i = 0; i < noOfStates; i++) {
            if (startState == states[i]) {
                x = i;
                break;
            }
        }

        //number of final state(s)
        int noOfFinal = sc.nextInt();
        sc.nextLine();

        //name of final state(s)
        char finalStates[] = new char[noOfFinal];
        st = new StringTokenizer(sc.nextLine());
        num = 0;
        while (st.hasMoreTokens()) {
            finalStates[num++] = st.nextToken().charAt(0);
        }

        //string to be detected
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                x = table[x][0];
            } else
                x = table[x][1];
        }

        int isAccepted = 0;
        for (int i = 0; i < noOfFinal; i++) {
            if (states[x] == finalStates[i]) {
                isAccepted = 1;
                break;
            }
        }
        if (isAccepted == 1)
            System.out.println("Accepted");
        else
            System.out.println("Rejected");
    }
}