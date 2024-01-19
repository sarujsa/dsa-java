package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Dota2 Senate.
 */
public class P649 {

    public static void main(String[] args) {
        P649 p = new P649();
        System.out.println(p.predictPartyVictory("RDDRRRDDDDRRRRRD"));
        System.out.println(p.predictPartyVictory("DRRDDDRRRRDDDDDR"));
        System.out.println(p.predictPartyVictory("R"));
        System.out.println(p.predictPartyVictory("D"));
        System.out.println(p.predictPartyVictory("RD"));
        System.out.println(p.predictPartyVictory("DR"));
        System.out.println(p.predictPartyVictory("RDD"));
        System.out.println(p.predictPartyVictory("DDR"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Character> q = new ArrayDeque<>(senate.length());
        int Dminus = 0;
        int Rminus = 0;
        int limit = senate.length();
        for(int i = 0; i < limit; i++) {
            if(senate.charAt(i)  == 'R') {
                if(Rminus == 0) {
                    Dminus++;
                    q.add('R');
                } else {
                    Rminus--;
                }
            } else {
                if (Dminus == 0) {
                    Rminus++;
                    q.add('D');
                } else {
                    Dminus--;
                }
            }
        }
        Character head = null;
        boolean cont = true;
        while(cont) {
            int size = q.size();
            head = q.peek();
            cont = false;
            int i = 0;
            while(!q.isEmpty()) {
                var c = q.poll();
                if(c != head) {
                    cont = true;
                }
                if(c  == 'R') {
                    if(Rminus == 0) {
                        Dminus++;
                        q.add('R');
                    } else {
                        Rminus--;
                    }
                } else {
                    if (Dminus == 0) {
                        Rminus++;
                        q.add('D');
                    } else {
                        Dminus--;
                    }
                }
                i++;
                if(i >= size) {
                    break;
                }
            }
        }
        if(head == 'R') {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}
