package DS2020.Assignment_08;

import java.util.*;

public class Assignment_08 {

    public static void main(String[] args) {
        String depths = "9 MobileApplications, 48 WebProgramming2, 0 DataMining, 24 AnalysisofAlgorithms, 43 OperatingSystems2, 64 MachineLearning, -1, 13 MobileApplications";
        String a = "35 DataStructuresandAlgorithms, 8 LinearAlgebra, 65 OperatingSystems2, 3 DataStructuresandAlgorithms, 2 DatabaseSystems2, 32 ProgrammingJava1, 1 DifferentialEquations, 6 CommunicationsandNetworking, 65 ProgrammingJava1, -1, 5 AdvancedDatabaseSystems, 8 SoftwareEngineering, 3 AdvancedDataStructures, 2 ProgrammingJava1, 5 ComputerGraphics, 1 DataMining, 31 AdvancedAlgorithms, -1, 77 WebProgramming1, 0 MachineLearning, 28 ArtificialIntelligence, 84 AdvancedDataStructures, 9 CalculusC, 8 InformationRetrieval, 2 DataMining, 5 ComputerSystems, 51 CalculusA, 1 MachineLearning, 49 InformationRetrieval, 50 DifferentialEquations, 67 ComputerGraphics, 84 Programming2, 0 ComparativeProgrammingLanguages, 65 WebProgramming2, 1 ComparativeProgrammingLanguages, -1, 7 DataStructuresandAlgorithms, 30 ComputerGraphics, 1 LinearAlgebra, 4 CommunicationsandNetworking, 7 ComputerGraphics, 94 ComputerGraphics, 40 CalculusC, 19 DatabaseSystems1, 9 AdvancedDatabaseSystems, 8 Programming2, -1, 91 DiscreteMathematics, 1 Security, 67 ComputerSystems, 1 CalculusC, 49 WebProgramming2, 95 CommunicationsandNetworking, 31 AdvancedAlgorithms, 0 IntroductiontoProgramming, 12 DataStructuresandAlgorithms, 8 ComputerGraphics, 95 SoftwareEngineering, 9 AdvancedNetworking, 1 WebProgramming2, 21 OperatingSystems2, 7 ComputerGraphics, 3 LinearAlgebra, -1, 0 MobileApplications, 9 MachineLearning, 5 AnalysisofAlgorithms, 42 AdvancedNetworking, 0 AnalysisofAlgorithms, 5 AdvancedAlgorithms, 67 WebProgramming2, 47 DatabaseSystems2, 1 OperatingSystems, 14 ComparativeProgrammingLanguages, 76 AdvancedDatabaseSystems, 26 AnalysisofAlgorithms, -1, -1, 83 LinearAlgebra, 74 AdvancedDataStructures, -1, 5 AdvancedNetworking, 23 DataStructuresandAlgorithms, 0 DatabaseSystems2, 61 AnalysisofAlgorithms, 1 MachineLearning, 6 LinearAlgebra, 77 Security, 86 OperatingSystems, 13 LinearAlgebra, 7 AdvancedDatabaseSystems, 0 ProgrammingJava1, 26 CommunicationsandNetworking, 51 CalculusB, 7 LinearAlgebra, -1, 79 AdvancedDataStructures";
        String f = "9 english, 6 math, 8 art, -1, 3 graphics, -1";
        String e = "97 OperatingSystems2, 7 DatabaseSystems1, -1, 0 MobileApplications, 62 AdvancedAlgorithms, 1 Programming2, 80 WebProgramming1, 79 DiscreteMathematics, -1, 8 AdvancedDatabaseSystems, 27 DatabaseSystems1, 2 AdvancedNetworking, 57 IntroductiontoProgramming, -1, 99 MachineLearning, 4 AdvancedAlgorithms, 4 ComputerGraphics, -1, 99 DataMining, 13 WebProgramming1, -1, -1, 98 MobileApplications, 3 AdvancedDataStructures, 7 AdvancedNetworking, 7 DataStructuresandAlgorithms, 72 Programming2, 7 DiscreteMathematics, 39 CalculusC, 3 AnalysisofAlgorithms, 6 LinearAlgebra, 3 Programming2, 8 ArtificialIntelligence, 7 IntroductiontoProgramming, 40 MachineLearning, 5 ComputerGraphics, 53 ComputerSystems, 3 AdvancedAlgorithms, 73 CalculusB, 39 DiscreteMathematics, 9 CalculusC, 1 IntroductiontoProgramming, 5 DatabaseSystems2, 89 AdvancedAlgorithms, 4 WebProgramming2, 1 DifferentialEquations, 16 MachineLearning, 1 CommunicationsandNetworking, 4 OperatingSystems2, 3 AdvancedAlgorithms, 94 ArtificialIntelligence, -1, 97 AdvancedDatabaseSystems, 61 DataStructuresandAlgorithms, 0 WebProgramming2, 86 IntroductiontoProgramming, 5 Security, 16 AdvancedAlgorithms, 99 CalculusB, 59 ComparativeProgrammingLanguages, 2 MachineLearning, 7 Programming2, 9 Programming2, 5 ComputerSystems, 65 OperatingSystems, 4 ComputerGraphics, 19 OperatingSystems2, 6 CalculusA, 6 MachineLearning, 4 WebProgramming2, 73 MachineLearning, 3 CalculusA, 6 AnalysisofAlgorithms, 59 InformationRetrieval, 4 SoftwareEngineering, 3 ComputerSystems, 49 ProgrammingJava1, 3 WebProgramming2, 88 IntroductiontoProgramming, 3 WebProgramming2, 5 CalculusC, 94 CalculusC, -1, 58 DataMining, 83 CommunicationsandNetworking, 6 DifferentialEquations, 82 AdvancedDataStructures";
        String h = "7 AdvancedDatabaseSystems, -1, 90 AnalysisofAlgorithms, 14 DataMining, 9 MachineLearning, -1, 97 Security, 3 CalculusC, 44 WebProgramming2, 5 AdvancedAlgorithms, 5 ComparativeProgrammingLanguages, 0 DatabaseSystems1, 68 DataStructuresandAlgorithms, 5 DataMining, -1";
        String[] b = a.split(", ");
        String g = "0 testo, 0 testo, -1";
        String[] c = {"35 DataStructuresandAlgorithms", "8 LinearAlgebra", "65 OperatingSystems2", "3 DataStructuresandAlgorithms", "2 DatabaseSystems2", "32 ProgrammingJava1", "1 DifferentialEquations", "6 CommunicationsandNetworking", "65 ProgrammingJava1", "-1"};
        System.out.println(whichBook(g.split(", ")));
        permutationNorRecursive(6);
    }


     // Q 1
    class QueueByTwoStack<E> {
        Stack<E> a = new Stack<>();
        Stack<E> b = new Stack<>();

        private E head;

        public int size() {
            //write code here
            return a.size() + b.size();
        }

        public boolean isEmpty() {
            //write code here
            return a.isEmpty() && b.isEmpty();
        }


        public void eneque(E e) {
            //write code here
            if (a.isEmpty()) {
                head = e;
            }

        }


        public E deque() {
            //write code here
            if (isEmpty()) {
                return null;
            }

            if (!b.isEmpty())
                return b.pop();

            while (!a.isEmpty())
                b.push(a.pop());

            return b.pop();
        }

        public E first() {
            if (isEmpty()) {
                return null;
            }
            //write code here
            if (!b.isEmpty())
                return b.peek();

            return head;
        }


        @Override
        public String toString() {
            if (isEmpty()) {
                return "[]";
            }
            Stack<E> temp = new Stack<>();
            String str = new String();
            str += '[';

            while (!b.isEmpty()) {
                temp.push(b.pop());
                str += temp.peek() + ", ";
            }

            if (a.isEmpty()) {
                while (!temp.isEmpty()) {
                    b.push(temp.pop());
                }
                return str.substring(0, str.length() - 2) + ']';
            }


            while (!a.isEmpty()) {
                b.push(a.pop());
            }

            while (!b.isEmpty()) {
                temp.push(b.pop());
                str += temp.peek() + ", ";
            }
            while (!temp.isEmpty()) {
                b.push(temp.pop());
            }
            return str.substring(0, str.length() - 2) + ']';

        }
    }
     // End of Q 1


     // Q 2
    public static void changeDeque(Stack<Integer> S, Deque<Integer> depths) {
        int n = depths.size();
        for (int i = 0; i < n; i++) {
            if (i == depths.size() / 2) {
                int a = depths.pop(), b = depths.pop();
                S.push(b);
                S.push(a);
                i += 1;
                continue;
            }
            S.push(depths.pop());
        }
        for (int i = 0; i < n; i++) {
            depths.push(S.pop());
        }

    }
     // End of Q 2


    // Q 3
//    static class Stack {
//
//        private ArrayList<Character> stack;
//        private int top;
//
//        public Stack() {
//            this.top = 0;
//            stack = new ArrayList<Character> ();
//        }
//
//        public int size () {
//            return top;
//        }
//
//        public void push (char item) {
//            stack.add (top++, item);
//        }
//
//        public char pop () {
//            return stack.remove (--top);
//        }
//    }


    // Q 3
    public static void permutationNorRecursive(int number){
    String str = "";

    for(int i=1; i<=number ; i++) { str += i; }

    int[] factorials = new int[number+1];
    factorials[0] = 1;

    for (int i = 1; i<=number;i++) { factorials[i] = factorials[i-1] * i; }

    for (int i = 0; i < factorials[number]; i++) {

        Stack<Character> permute = new Stack<>();
        String temp_str = str;
        int c = i;
        for (int j = number; j > 0 ;j--){

            int s = c / factorials[j-1];

            permute.push(temp_str.charAt(s));
            c = c % factorials[j-1];
            temp_str = temp_str.substring(0,s) + temp_str.substring(s+1);

        }
        print(permute);
    }
}
    public static void print(Stack<Character> s){
        while(!s.isEmpty()) { System.out.print(s.pop()); }
        System.out.println();
    }
    // End of Q 3

    
     // Q 4
    public static List<String> whichBook(String[] actions) {
        Stack<String> all = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        List<String> res = new ArrayList<>();

        int depth = 0;
        if (actions.length == 0) {
            return res;
        }
        int j;
        for(j=0;j<actions.length;j++){
            if(Long.parseLong(actions[j].split(" ")[0])>0)
                break;
        }
        if(j>=actions.length)return res;
        all.push(actions[j]);
        for (int i = j+1; i < actions.length; i++) {
            if (actions[i].length() == 2) {
                res.add(depth + " " + all.pop().split(" ")[1]);

                if(!depths.isEmpty()) {
                    depth = depths.pop();
                }
                else {
                    depth = 0;
                }
            } else {
                long qs = Long.parseLong(actions[i].split(" ")[0]);
                if (qs == 0) {
                    continue;
                } else {
                    if (all.isEmpty()) {
                        all.push(actions[i]);
                        depths.push(depth);
                    } else if (qs > Long.parseLong(all.peek().split(" ")[0])) {
                        depth++;
                    } else {
                        depths.push(depth);
                        depth = 0;
                        all.push(actions[i]);
                    }
                }
            }
        }
        return res;
    }
     // End of Q 4

}

