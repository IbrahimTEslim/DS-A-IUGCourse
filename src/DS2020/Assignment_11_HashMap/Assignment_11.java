package DS2020.Assignment_11_HashMap;

import java.util.*;

public class Assignment_11 {
    public static void main(String[] args) {
        char[][] a = {{'a', 'b'}, {'b', 'a'}, {'c', 'd'}, {'d', 'c'}};
        System.out.println(matchingLetters(a));


    }


    // Q 1
    public static boolean AreSetsEquivalent(int[] arr, int[] brr) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!s1.contains(arr[i])) {
                s1.add(arr[i]);
                sum1 += arr[i];
            }
        }
        for (int i = 0; i < brr.length; i++) {
            if (!s2.contains(brr[i])) {
                s2.add(brr[i]);
                sum2 += brr[i];
            }
        }
        return sum1 == sum2;
    }
    // End of Q 1


    // Q 2
    public static boolean findSum(int[] arr, int sum) {
        if (arr.length <= 1) return false;
        java.util.HashSet<Integer> s = new java.util.HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            // checking for condition
            if (s.contains(temp)) {
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }
    // End of Q 2


    // Q 3
    public static void removeDuplicate(/*DoublyLinkedList<Integer> dll*/) {
        /*  HashSet<Integer> set = new HashSet<>();
            Node<Integer> walk=dll.first();
            while (walk != null) {
                if (!set.contains(walk.getElement())) {
                    set.add(walk.getElement());
                }
                else{
                    if(walk.getNext()!=null)
                        walk.getNext().setPrev(walk.getPrev());
                    walk.getPrev().setNext(walk.getNext());
                }
                walk=walk.getNext();
            }
        }       *///////
    }
    // End of Q 3


    // Q 4
    public static List<List<Character>> matchingLetters(char[][] ch) {
        List<List<Character>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            String temp_str = new String(ch[i]);
            StringBuilder temp_strB = new StringBuilder(temp_str);
            if (set.contains(String.valueOf(ch[i])) || set.contains(temp_strB.reverse())) {
                List<Character> temp = new ArrayList<>();
                temp.add(ch[i][1]);
                temp.add(ch[i][0]);
                res.add(temp);
            } else {
                String t = new String(ch[i]);
                set.add(t);
                temp_strB = new StringBuilder(t);
                set.add(temp_strB.reverse().toString());
            }
        }
        return res;
    }
    // End of Q 4


    // Q 5
    public static boolean searchSum3d(int[] a, int[] b, int[] c, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (set.contains(m - c[j] - b[i]))
                    return true;
            }
        }
        return false;
    }
    // End of Q 5


    // Q 6
    public class PhoneDirectory {
        HashMap<String, String> phoneDirectory = new HashMap<>();
        HashMap<String, String> helperPhoneDirectory = new HashMap<>();

        public void insert(String name, String phone) {
            //write code here
            phoneDirectory.put(name, phone);
            helperPhoneDirectory.put(phone, name);
        }

        public String findNumber(String name) {
            //write code here
            if (phoneDirectory.containsKey(name)) {
                return phoneDirectory.get(name);
            }
            return "";
        }

        public String findName(String phone) {
            //write code here
            if (helperPhoneDirectory.containsKey(phone)) {
                return helperPhoneDirectory.get(phone);
            }
            return "";
        }

        public void removeByName(String name) {
            //write code here
            helperPhoneDirectory.remove(phoneDirectory.get(name));
            phoneDirectory.remove(name);
        }

        public void removeByPhone(String number) {
            //write code here
            phoneDirectory.remove(helperPhoneDirectory.get(number));
            helperPhoneDirectory.remove(number);
        }
    }
    // End of Q 6


    // Q 7
    public class PhoneDirectory2 {
        HashMap<String, List<String>> phoneDirectory = new HashMap<>();
        HashMap<String, String> helperPhoneDirectory = new HashMap<>();

        public void insert(String name, String phones) {
            //write code here
            if (phoneDirectory.get(name) == null)
                phoneDirectory.put(name, new ArrayList<>());

            phoneDirectory.get(name).add(phones);

            helperPhoneDirectory.put(phones, name);
        }

        public List<String> findNumber(String name) {
            //write code here
            return phoneDirectory.get(name);
        }

        public String findName(String phone) {
            //write code here
            if (helperPhoneDirectory.containsKey(phone)) {
                return helperPhoneDirectory.get(phone);
            }
            return "null";
        }

        public void removeByName(String name) {
            //write code here
            if(!phoneDirectory.containsKey(name)) return;
            List<String> temp=phoneDirectory.remove(name);
            for (int i = 0; i < temp.size(); i++) {
                helperPhoneDirectory.remove(temp.get(i));
            }
        }

        public void removeByPhone(String number) {
            //write code here
            if(!helperPhoneDirectory.containsKey(number)) return;

            List<String> temp = phoneDirectory.get(helperPhoneDirectory.get(number));
            if(temp.size()==1) {
                phoneDirectory.remove(helperPhoneDirectory.remove(number));
                return;
            }
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i).equals(number)){
                    temp.remove(i);
                    return;
                }
            }
        }
    }
    // End of Q 7


    // Q 8
    public static void spellCheck(List<String> dec, String text) {
        HashSet<String> d = new HashSet<>();
        for (int i = 0; i < dec.size(); i++) {
            d.add(dec.get(i));
        }

        String[] words = text.split(" ");
        for (int z = 0; z < words.length; z++) {
            if (d.contains(words[z]))
                continue;
            HashSet<String> suggestions_set = new HashSet<>();

            // Checking if any character missing
            for (int i = 'a'; i <= 'z'; i++) {
                for (int j = 0; j <= words[z].length(); j++) {
                    if (d.contains(words[z].substring(0, j) + (char) i + words[z].substring(j)))
                        suggestions_set.add(words[z].substring(0, j) + (char) i + words[z].substring(j));
                }
            }

            // Checking if any character over
            for (int i = 1; i <= words[z].length(); i++) {
                if (d.contains(words[z].substring(0, i - 1) + words[z].substring(i)))
                    suggestions_set.add(words[z].substring(0, i - 1) + words[z].substring(i));
            }


            // Checking if any two char need replaced
            for (int i = 1; i < words[z].length()-1; i++) {
                char[] temp=words[z].toCharArray();
                char index=temp[i];
                char x=temp[i+1];
                temp[i+1]=temp[i];
                temp[i]=x;
                if(d.contains(String.valueOf(temp)))
                    suggestions_set.add(String.valueOf(temp));
                temp[i+1]=x;

                x=temp[i-1];
                temp[i-1]=index;
                temp[i]=x;

                if(d.contains(String.valueOf(temp)))
                    suggestions_set.add(String.valueOf(temp));
            }


            List<String> suggestions = new ArrayList<>(suggestions_set);
            Collections.sort(suggestions);
            System.out.println(words[z] + " " + suggestions);
        }
    }
    // End of Q 8


}