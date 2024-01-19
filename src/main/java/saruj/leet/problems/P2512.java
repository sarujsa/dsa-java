package saruj.leet.problems;

import java.util.*;

/**
 * Reward Top K students.
 */
public class P2512 {

    public static void main(String[]args) {
        String[] pf = new String[]{"xrezzxgdvg","bcgx","wcfzmfosr"};
        String [] nf = new String[]{"qyouhus","ukou","eirhfbt","qciw","for"};
        String [] report = new String[]{"bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw","bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw","xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr","for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt","loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg","rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx","bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg","bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr","qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"};
        int[] ids = new int[]{686276715,934288178,625397331,519945877,864052244,971253305,512505036,865635090,281613863};

        int k = 9;
        List<Integer> list = new Solution().topStudents(pf, nf, report, ids, k);
        System.out.println(list);
    }

    static class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
                                         String[] report, int[] student_id, int k) {
            Set<String> positive = setFromArray(positive_feedback);
            Set<String> negative = setFromArray(negative_feedback);
            PriorityQueue<Student> pqueue = new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1.feedback < o2.feedback) {
                            return -1;
                        } else if (o1.feedback > o2.feedback) {
                            return 1;
                        } else {
                            if (o1.id < o2.id) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    });
            for(int i = 0; i < report.length; i++) {
                Student s = getStudent(report, student_id, i, positive, negative);
                pqueue.add(s);
            }
            List<Integer> result = new ArrayList<>(k);
            for(int i = 0; i < k; i++) {
                result.add(pqueue.poll().id);
            }
            return result;
        }

        private Student getStudent(String[] report, int[] studentId, int i,
                                   Set<String> positive, Set<String> negative) {
            int sum = 0;
            for(String word : report[i].split(" ")) {
                if(positive.contains(word)) {
                    sum -= 3;
                } else if (negative.contains(word)) {
                    sum += 1;
                }
            }
            return new Student(studentId[i], sum, i);
        }

        static class Student {
            int id;
            int feedback;
            int index;

            @Override
            public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", feedback=" + feedback +
                        ", index=" + index +
                        '}';
            }

            public int getId() {
                return id;
            }

            public int getFeedback() {
                return feedback;
            }

            public Student(int id, int feedback, int index) {
                this.id = id;
                this.feedback = feedback;
                this.index = index;
            }
        }

        private Set<String> setFromArray(String[] array) {
            Set<String> ret = new HashSet<>();
            for(String s : array) {
                ret.add(s);
            }
            return ret;
        }
    }
}
