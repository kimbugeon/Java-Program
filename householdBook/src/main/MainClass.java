package main;

import dao.HouseHoldDao;
import dao.HouseHoldDaoImpl;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HouseHoldDao dao = new HouseHoldDaoImpl();

        boolean loopStop = true;

        while (loopStop){
            System.out.println("<가계부 정리 프로그램>");
            System.out.println("1.내용 추가");
            System.out.println("2.내용 삭제");
            System.out.println("3.검색");
            System.out.println("4.결산");
            System.out.println("5.업데이트");
            System.out.println("6.모두 출력");
            System.out.println("7.데이터 불러오기");
            System.out.println("8.데이터 저장");
            System.out.println("9.프로그램 종료");

            System.out.print("메뉴번호 입력 : ");
            int menu = sc.nextInt();

            switch (menu){
                case 1:
                    dao.insert();
                    break;
                case 2:
                    dao.delete();
                    break;
                case 3:
                    dao.select();
                    break;
                case 4:
                    dao.bottom();
                    break;
                case 5:
                    dao.update();
                    break;
                case 6:
                    dao.print();
                    break;
                case 7:
                    dao.dataLoad();
                    break;
                case 8:
                    dao.dataSave();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    loopStop = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
    }
}
