package com.homework0725;

import java.util.Scanner;

public class HW02 {

    public static String[] getIllegalWords() {
        return new String[]{"性", "色情", "爆炸", "恐怖", "枪", "军火"};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("聊天内容：");
        StringBuilder inputWords = new StringBuilder(input.next());
        String[] str = getIllegalWords();
        System.out.println("过滤前：" + inputWords);
        for (int i = 0; i < inputWords.length(); i++) {
            for (int j = 0; j < str.length; j++) {
                int index = inputWords.indexOf(str[j]);
                if (index != -1) {
                    for (int k = 0; k < str[j].length(); k++) {
                        inputWords.setCharAt(index + k, '*');
                    }
                }
            }
        }

        System.out.println("过滤后：" + inputWords);
    }

}
