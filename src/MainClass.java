import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        /*
            성적관리 프로그램

            과목(국, 영, 수)
            학생수(?)
            총점, 평균, 과목당 최고점수, 최저점수
             국   영  수
            {55, 33, 22}
            {11, 22, 33}
            {56, 43, 23}
        */
        Scanner sc = new Scanner(System.in);
        int menuNumber = 0;
        int student[][] = null;

        while(true){
            System.out.println("<성적관리 프로그램>");
            System.out.println("1. 학생점수 입력");
            System.out.println("2. 학생점수 총점");
            System.out.println("3. 학생점수 평균");
            System.out.println("4. 과목의 최고점수");
            System.out.println("5. 과목의 최저점수");
            System.out.println("6. 과목의 평균점수");
            System.out.println("7. 종료");

            System.out.print("메뉴번호 >> ");
            menuNumber = sc.nextInt();

            if(menuNumber == 1){
                // 입력
                // 몇명
                System.out.print("몇명의 학생이 있나요? ");
                int studentLen = sc.nextInt();
                student = new int[studentLen][3];
                // 각점수
                System.out.println("국어, 영어, 수학 점수를 차례로 입력하세요. ");
                for(int i = 0; i < student.length; i++){
                    System.out.print((i + 1) + "번째 학생의 점수: ");
                    for(int j = 0; j < student[i].length; j++) {
                        student[i][j] = sc.nextInt();
                    }
                }
                System.out.println("학생들의 점수");
                for (int i = 0; i < student.length; i++) {
                    System.out.print((i + 1) + "번째 학생: ");
                    for (int j = 0; j < student[i].length; j++) {
                        System.out.print(student[i][j] + " ");
                    }
                    System.out.println();
                }

            } else if(menuNumber == 2) {
                // ?번째 학생의 점수총점
                int sumMax = 0;

                System.out.println("몇번 학생의 총점을 알고싶나요?");
                int numberO = sc.nextInt();
                int numberT = numberO -1;
                int counter = 0;

                for(int i = 0; i < student[numberT].length; i++){
                    counter += student[numberT][i];
                }

                System.out.println(numberO + "번째 학생의 총점 : " + counter);

            } else if(menuNumber == 3){
                // ?번째 학생의 점수평균
                System.out.println("몇번 학생의 평균을 알고싶나요?");
                int numberO = sc.nextInt();
                int numberT = numberO -1;
                int counter = 0;

                for(int i = 0; i < student[numberT].length; i++){
                    counter += student[numberT][i];
                }

                double avg = (double)counter / student[numberT].length;

                System.out.println(numberO + "번째 학생의 평균 : " + avg);

            } else if(menuNumber == 4){
                // 과목의 최고점수
                // 국, 영, 수 선택
                System.out.print("국어, 영어, 수학 중에 선택 : ");
                String langName = sc.next();
                int max = 0;

                switch(langName){
                    case "국어":
                        max = student[0][0];
                        for(int i = 0; i < student.length; i++){
                            if(max < student[i][0]){
                                max = student[i][0];
                            }
                        }
                        System.out.println("국어 과목의 최고 점수는 " + max + "입니다.");
                        break;

                    case "영어":
                        max = student[0][1];
                        for(int i = 0; i < student.length; i++){
                            if(max < student[i][1]){
                                max = student[i][1];
                            }
                        }
                        System.out.println("영어 과목의 최고 점수는 " + max + "입니다.");
                        break;

                    case "수학":
                        max = student[0][2];
                        for(int i = 0; i < student.length; i++){
                            if(max < student[i][2]){
                                max = student[i][2];
                            }
                        }
                        System.out.println("수학 과목의 최고 점수는 " + max + "입니다.");
                        break;
                }
            } else if(menuNumber == 5){
                // 과목의 최저점수
                // 국, 영, 수 선택
                System.out.print("국어, 영어, 수학 중에 선택 : ");
                String langName = sc.next();
                int min = 0;

                if(langName.equals("국어")){
                    min = student[0][0];
                    for(int i = 0; i < student.length; i++){
                        if(min > student[i][0]){
                            min = student[i][0];
                        }
                    }
                    System.out.println("국어 과목의 최저 점수는 " + min + "입니다.");

                } else if(langName.equals("영어")){
                    min = student[0][1];
                    for(int i = 0; i < student.length; i++){
                        if(min > student[i][1]){
                            min = student[i][1];
                        }
                    }
                    System.out.println("영어 과목의 최저 점수는 " + min + "입니다.");

                } else if(langName.equals("수학")){
                    min = student[0][2];
                    for(int i = 0; i < student.length; i++){
                        if(min > student[i][2]){
                            min = student[i][2];
                        }
                    }
                    System.out.println("수학 과목의 최저 점수는 " + min + "입니다.");
                }

            } else if(menuNumber == 6){
                System.out.print("국어, 영어, 수학 중에 선택 : ");
                String langName = sc.next();

                if(langName.equals("국어")){ // student[][0]

                    int counter = 0;
                    for(int i = 0; i < student.length; i++){
                        counter += student[i][0];
                    }
                    System.out.println("총점: " + counter);

                    double avg = (double)counter / student.length;
                    System.out.println("평균 : " + avg);


                } else if(langName.equals("영어")){ // student[][1]
                    int counter = 0;
                    for(int i = 0; i < student.length; i++){
                        counter += student[i][1];
                    }
                    System.out.println("총점: " + counter);

                    double avg = (double)counter / student.length;
                    System.out.println("평균 : " + avg);

                } else if(langName.equals("수학")){ // student[][2]
                    int counter = 0;
                    for(int i = 0; i < student.length; i++){
                        counter += student[i][2];
                    }
                    System.out.println("총점: " + counter);

                    double avg = (double)counter / student.length;
                    System.out.println("평균 : " + avg);
                }
            } else if(menuNumber == 7){
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }
}
