package main;
import main.dao.StudentDao;
import main.file.FileClass;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // menu
        StudentDao dao = new StudentDao();
        FileClass fileClass = new FileClass(dao.getStudents());
        // StudentDao와 FileClass간의 데이터 공유하기 위함
        // 배열을 전달하여 FileClass에서 사용할 수 있도록 하기 위함(연결고리 느낌)

        boolean running = true;

        while(running){
            System.out.println(" < 학생관리 프로그램 > ");
            System.out.println("1. 학생추가");
            System.out.println("2. 학생삭제");
            System.out.println("3. 학생검색");
            System.out.println("4. 학생수정");
            System.out.println("5. 모두출력");
            System.out.println("6. 데이터 불러오기");
            System.out.println("7. 데이터 저장");
            System.out.println("8. 프로그램 종료");

            System.out.print("메뉴번호를 입력 : ");
            int menu = sc.nextInt();

            switch(menu){
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
                    dao.pirnt();
                    break;
                case 6:
                    fileClass.load();
                    break;
                case 7:
                    try {
                        fileClass.create();
                        fileClass.save();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("학생 정보가 파일에 저장되었습니다.");
                    break;

                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력하세요.");
            }
        }
    }
}