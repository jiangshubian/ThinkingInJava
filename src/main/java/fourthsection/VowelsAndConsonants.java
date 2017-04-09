package fourthsection;

import java.util.Random;

/**
 * use switch
 * Created by 123 on 2017/4/9.
 * @author jiangshubian
 * @version 1.0
 */
public class VowelsAndConsonants {

    public static void main(String[] args) {
        Random random = new Random(47);//47: AtomicLong seed
        for (int i = 0; i < 27; i++) {
            int c = random.nextInt(26) + 'a'; //create 26 work:a-z
            System.out.println("char(c):" + (char) c + ",c:" + c);

            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowels.");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes a vowels.");
                    break;
                default:
                    System.out.println("consonant.");
            }
        }
    }

}
