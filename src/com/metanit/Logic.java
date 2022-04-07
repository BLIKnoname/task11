package com.metanit;

public class Logic {


    public static String decod (String message, int shift) {
      String  RUS1 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
      String  RUS2 = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
      String  LAT1 = "abcdefghijklmnopqrstuvwxyz";
      String  LAT2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      String textOut = " ";
      int index;

      for (int i = 0; i < message.length(); i++) {

          if (isLetterOrDigitRusUp(message.charAt(i))) {
              index = (RUS2.indexOf(message.charAt(i)) + shift) % 33;
              textOut += RUS2.charAt(index);
          }

          else if (isLetterOrDigitRusLow(message.charAt(i))) {
              index = (RUS1.indexOf(message.charAt(i)) + shift) % 33;
              textOut += RUS1.charAt(index);
          }

          else if (isLetterOrDigitEngLow(message.charAt(i))) {
              index = (LAT1.indexOf(message.charAt(i)) + shift) % 26;
              textOut += LAT1.charAt(index);
          }

         else if (isLetterOrDigitEngUp(message.charAt(i))) {
              index = (LAT2.indexOf(message.charAt(i)) + shift) % 26;
              textOut += LAT2.charAt(index);
          }

         else {
             textOut += "";
          }

      }

      return textOut;
    }

    private static boolean isLetterOrDigitEngUp(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isLetterOrDigitEngLow(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isLetterOrDigitRusUp(char c) {
        return (c >= 'А' && c <= 'Я');
    }

    private static boolean isLetterOrDigitRusLow(char c) {
        return (c >= 'а' && c <= 'я');
    }
}
