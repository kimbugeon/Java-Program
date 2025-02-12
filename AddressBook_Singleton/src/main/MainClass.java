package main;

import dao.AddressDao;
import dao.AddressDaoImpl;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressDao dao = new AddressDaoImpl();

        boolean end = false;

        while (true){
            System.out.println("<주소록>");
            System.out.println("1.주소추가");
            System.out.println("2.주소삭제");
            System.out.println("3.주소수정");

            System.out.println("4.이름검색");
            System.out.println("5.주소검색");
            System.out.println("6.메모검색");

            System.out.println("7.데이터저장");
            System.out.println("8.데이터불러오기");

            System.out.println("9.종료");

            System.out.print("입력 >> ");
            int number = sc.nextInt();

            if(number == 1)         dao.insert();
            else if(number == 2)    dao.delete();
            else if(number == 3)    dao.update();
            else if(number == 4)    dao.nameSelect();
            else if(number == 5)    dao.addressSelect();
            else if(number == 6)    dao.memoSelect();
            else if(number == 7)    dao.dataSave();
            else if(number == 8)    dao.dataLoad();
            else                    end = true;

            if(end){
                System.out.println("프로그램 종료");
                break;
            }
        }


    }
}








