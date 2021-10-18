package service;

import model.PhoneBook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Active {
    public static String filePath = "src/data/contact.csv";

    public static List<PhoneBook> showPhoneBook() throws FileNotFoundException {
        List<PhoneBook> phoneBooksList = new ArrayList<>();
        List<String> records = CSVFile.readFile(filePath);
        for (String record: records) {
            phoneBooksList.add(new PhoneBook(record));
        }
        return phoneBooksList;
    }

    public static void savePhoneBook(List<PhoneBook> phoneBooks) throws IOException {
        List<String> records = new ArrayList<>();
        for (PhoneBook pB:phoneBooks) {
            records.add(pB.toString());
        }
        CSVFile.writeFile(filePath, records);
    }

    public static void insert(PhoneBook phoneBook) throws IOException {
        List<PhoneBook> phoneBookList = showPhoneBook();
        Scanner input = new Scanner(System.in);
        System.out.print("Mời bạn nhập số điện thoại : ");
        String phonenumber = input.next();
        System.out.print("Mời bạn nhập tên nhóm : ");
        String group = input.next();
        System.out.print("Mời bạn nhập tên : ");
        String name = input.next();
        System.out.print("Mời bạn nhập giới tính : ");
        String gender = input.next();
        System.out.print("Mời bạn nhập địa chỉ: ");
        String address = input.next();
        PhoneBook phoneBook1 = new PhoneBook(phonenumber,group,name, gender, address);
        phoneBookList.add(phoneBook1);
        savePhoneBook((List<PhoneBook>) phoneBook1);
    }

    public static void delete() throws IOException {
        List<PhoneBook> phoneBookList = showPhoneBook();
        if (phoneBookList.size() != 0) {
            System.out.println("Nhap vi tri can xoa");
            Scanner input = new Scanner(System.in);
            int inputIndex = input.nextByte();
            phoneBookList.remove(inputIndex);
            savePhoneBook(phoneBookList);
        }
    }

    public static void search() throws IOException {
        System.out.println("Nhập tên hoặc số bạn cần tìm:");
        Scanner scanner = new Scanner(System.in);
        String searchCharacter = scanner.nextLine();
        List<String> result = new ArrayList<>(CSVFile.readFile(filePath));
        List<String> afterSearch = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).contains(searchCharacter)) {
                afterSearch.add(result.get(i));
            } else{
                System.out.println("Không có trong danh sách");
            }
        }
        for (int i = 0; i < afterSearch.size(); i++) {
            System.out.println(afterSearch.get(i));
        }
    }
}
