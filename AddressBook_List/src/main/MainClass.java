package main;

import dao.AddressDao;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressDao adao = new AddressDao();
        boolean loopStop = true;

        while (loopStop){
            System.out.println("<주소록 관리 프로그램>");
            System.out.println("1.추가");
            System.out.println("2.삭제");
            System.out.println("3.검색");
            System.out.println("4.수정");
            System.out.println("5.모두출력");
            System.out.println("6.데이터불러오기");
            System.out.println("7.데이터저장");
            System.out.println("8.프로그램 종료");

            System.out.print("메뉴번호 입력 : ");
            int menu = sc.nextInt();

            switch (menu){
                case 1:
                    adao.insert();
                    break;
                case 2:
                    adao.delete();
                    break;
                case 3:
                    adao.select();
                    break;
                case 4:
                    adao.update();
                    break;
                case 5:
                    adao.print();
                    break;
                case 6:
                    adao.dataLoad();
                    break;
                case 7:
                    adao.dataSave();
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    loopStop = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
    }
}
