package pl.sda.proteinChains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProteinCheckers {

    private String proteinChains =
            "BDDFPQPPRRAGGHPOPDKJKPEQAAER\n" +
                    "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
                    "BDDFPQPFRRAGCHPOPDKJKPEQAAER\n" +
                    "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
                    "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
                    "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
                    "AABBCC\n" +
                    "ACBBCA\n" +
                    "BCBACA\n" +
                    "ACBBCA\n" +
                    "AABBCC\n" +
                    "BCBACA\n" +
                    "BCBACA\n" +
                    "AABBCCC\n" +
                    "AABBCC\n" +
                    "AABBCC\n" +
                    "ABBBCC\n" +
                    "AABCCC\n" +
                    "ABCAC\n" +
                    "CACBA\n" +
                    "AAAAAAAAAAAAAAAAAAAAB\n" +
                    "AAAAAAAAAAAAAAAAAAAAA\n" +
                    "QOOOOOOOOOOOOOOOOOOOO\n" +
                    "OOOOOOOOOOOOOOOOOOOOQ";

    @Test
    void checkProteins() {

        String[] lines = proteinChains.split("\n");
        for (int i = 0; i < lines.length; i = i + 2) {
            System.out.println(changePossible(lines[i], lines[i + 1]));
        }

    }

    private Boolean changePossible(String line1, String line2) {
        if (line1.length() != line2.length()) {
            return false;
        }
        if (line1.equals(line2)) {
            return true;
        }
        char[] chars1 = line1.toCharArray();
        char[] chars2 = line2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

}
