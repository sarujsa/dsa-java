package saruj.leet.problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class P394Test {

    @Test
    public void test() {
        P394 p = new P394();
        assertEquals(p.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"), "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
        assertEquals(p.decodeString("abuda2[2[2[A]]]bidobi"), "abudaAAAAAAAAbidobi");
        assertEquals(p.decodeString("methinks"), "methinks");
        assertEquals(p.decodeString("5[a]"), "aaaaa");
        assertEquals(p.decodeString("2[a2[b2[c]]]"), "abccbccabccbcc");
        assertEquals(p.decodeString("1[a]"), "a");
        assertEquals(p.decodeString("10[a]"), "aaaaaaaaaa");
        assertEquals(p.decodeString("3[a]fingernail4[o]"), "aaafingernailoooo");
        assertEquals(p.decodeString("2[ab2[cd]ef3[gh]]"), "abcdcdefghghghabcdcdefghghgh");
        assertEquals(p.decodeString("2[ab2[cd]ef3[gh2[a]2[b]ij]]"), "abcdcdefghaabbijghaabbijghaabbijabcdcdefghaabbijghaabbijghaabbij");
    }
}
