package service;

import model.PhoneBook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<PhoneBook> phoneBooks;
    PhoneBook phoneBook;
    public void mainMenu() throws IOException {
        String choice = "a";
        Scanner input = new Scanner(System.in);
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ");
        do {
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ File");
            System.out.println("7. Ghi vào File");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    Active.showPhoneBook();
                    break;
                case "2":
                    Active.insert(phoneBook);
                    break;
                case "3":
                    Active.savePhoneBook(phoneBooks);
                    break;
                case "4":
                    Active.delete();
                    break;
                case "5":
                    Active.search();
                    break;
                case "6":
                    Active.showPhoneBook();
                    break;
                case "7":
                    Active.savePhoneBook(phoneBooks);
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn nhập sai chức năng");
                    System.out.println("Bấm nút theo danh sách để tiêp tục");
                    System.out.println("=================================================");
            }
        } while ((choice != "8"));
    }


}
