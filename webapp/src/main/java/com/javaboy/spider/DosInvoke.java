package com.javaboy.spider;

import java.io.BufferedReader;
import java.io.IOException;


public class DosInvoke {
    public static void main(String[] args) throws IOException {
        try {
            String cmd = "cmd /c start "+"D:/java84_web/app/app/bat/merge.bat".replaceAll(" ", "\" \"");
            Process  process = Runtime.getRuntime().exec(cmd) ;
            //int exitVal = process.waitFor();
            //System.out.println("Exited with error code " + exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
