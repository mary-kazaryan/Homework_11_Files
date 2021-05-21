package TeachMeSkills;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Допустим есть файл с номерами документов.
// Номером документа является строка, состоящая из букв и цифр (без служебных символов).
// Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
// Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum
// (далее любая последовательность букв/цифр) или kontract (далее любая последовательность букв/цифр).
// Написать программу для чтения информации из входного файла - путь к входному файлу должне задаваться через консоль.
// Программа должна проверять номера документов на валидность.
// Валидные номера документов следует записать в один файл-отчет.
// Невалидные номера документов следует записать в другой файл-отчет,
// но после номеров документов следует добавить ифнформацию о том, почему этот документ невалиден.

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String fileAddress = sc.nextLine();

        File document = new File (fileAddress);

        if (document.exists()) {
            System.out.println("This document exists. The pathname of DocNumber document is: " + fileAddress);
            Scanner sc1 = new Scanner(document);

            ArrayList<String> validDocNumbers = new ArrayList<>();
            ArrayList<NotValidDocNumbers> notValidDocNumbers = new ArrayList<>();

            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                if (line.length() > 15) {
                    notValidDocNumbers.add(new NotValidDocNumbers(line, "length cannot exceed 15 letters"));
                } else if (!line.startsWith("docnum") && !line.startsWith("kontract")) {
                    notValidDocNumbers.add(new NotValidDocNumbers(line, "string should start with docnum or kontract"));
                } else if (!line.matches("^[a-zA-Z0-9]+$")) {
                    notValidDocNumbers.add(new NotValidDocNumbers(line, "string should have a specified set of letters"));
                } else {
                    validDocNumbers.add(line);}
            }

            File fileWithValidNumbers = new File
                    ("C:\\Users\\mkazaryan\\OneDrive - Sam Solutions\\Desktop\\Homework_11_Files_Docs\\Valid_DocNumbers.txt");
            File fileWithNotValidNumbers = new File
                    ("C:\\Users\\mkazaryan\\OneDrive - Sam Solutions\\Desktop\\Homework_11_Files_Docs\\Not_Valid_DocNumbers.txt");
            FileWriter fw1 = new FileWriter(fileWithValidNumbers);
            FileWriter fw2 = new FileWriter(fileWithNotValidNumbers);

            for (String line1 : validDocNumbers) {
                fw1.append(line1);
                fw1.append(System.lineSeparator());
            }
            fw1.flush();

            for (NotValidDocNumbers line2 : notValidDocNumbers) {
                fw2.append(line2.getNumber() + " comment: " + line2.getComment());
                fw2.append(System.lineSeparator());
            }
            fw2.flush();


        } else System.out.println("File is not found. Please try another pathname.");

        sc.close();
    }
}
