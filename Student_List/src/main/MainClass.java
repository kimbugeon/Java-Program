package main;

import dao.StudentDao;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // menu
        StudentDao dao = new StudentDao();

        while(true){
            System.out.println("< 학생관리 프로그램 >");
            System.out.println("1. 학생추가");
            System.out.println("2. 학생삭제");
            System.out.println("3. 학생검색");
            System.out.println("4. 학생수정");
            System.out.println("5. 모두출력");
            System.out.println("6. 데이터불러오기");
            System.out.println("7. 데이터저장");

            System.out.print("메뉴번호를 입력 >> ");
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
                    dao.update();
                    break;
                case 5:
                    dao.print();
                    break;
                case 6:
                    dao.dataLoad();
                    break;
                case 7:
                    dao.dataSave();
                    break;
            }
        }
    }
}







