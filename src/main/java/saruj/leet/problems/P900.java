package saruj.leet.problems;

/**
 * RLE Iterator
 */
public class P900 {

    class RLEIterator {

        int[] encoding;
        int counter;
        int index;
        public RLEIterator(int[] encoding) {
            if(encoding.length == 0) {
                index = 0;
            } else {
                counter = encoding[0];
                index = 1;
                this.encoding = encoding;
            }
        }

        public int next(int n) {
            if(index >= encoding.length) {
                return -1;
            } else {
                if(counter == 0) {
                    if(index >= encoding.length-1) {
                        return -1;
                    } else {
                        counter = encoding[index + 1];
                        index += 2;
                        return next(n);
                    }
                } else {
                    if(counter > n) {
                        counter -= n;
                        return encoding[index];
                    } else if (counter < n) {
                        int tmp = counter;
                        counter = 0;
                        return next(n-tmp);
                    } else {
                        counter = 0;
                        return encoding[index];
                    }
                }
            }
        }
    }
}
