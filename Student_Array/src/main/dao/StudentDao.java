package main.dao;
import main.dto.StudentDto;
import java.util.Scanner;

// Data Access Object
public class StudentDao {

    private Scanner sc;
    private StudentDto students[] = new StudentDto[10];
    private int count;

    public StudentDao() {
        sc = new Scanner(System.in);
        count = 0;
    }

    public void insert(){
        System.out.println("학생 정보를 입력해 주세요.");
        System.out.print("번호 : ");
        int number = sc.nextInt();

        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("키 : ");
        double height = sc.nextDouble();

        System.out.print("주소 : ");
        String address = sc.next();

        StudentDto dto = new StudentDto(number, name, height, address);
        students[count] = dto;
        count++;
    }

    public void delete(){
        System.out.print("삭제할 학생의 이름을 입력하세요 : ");
        String DelName = sc.next();

        for(int i = 0; i < count; i++){
            if(students[i].getName().equals(DelName)) { // 삭제할 이름과 일치하는 학생 찾기
                for(int j = i; j < count - 1; j++){ // 삭제 대상 이후의 요소들을 앞으로 이동
                    students[j] = students[j+1]; // 배열 재정렬 : 뒤의 학생들을 앞으로 이동
                }
                students[count - 1] = null;  // 마지막 요소를 null로 설정
                count--; // 학생 수 감소
                System.out.println("학생의 정보가 삭제되었습니다.");
                return;
            } // 김철수 이영희 황동수 에서 이영희가 타켓이면 -> 김철수 황동수 황동수 이렇게 된다.
             // 마지막 황동수는 어차피 null로 변환시켜서 삭제할거기 때문에 count - 1을 한다.
        }
        System.out.println("학생의 이름을 잘못 입력하였습니다.");
    }

    public void select(){
        System.out.println("조회할 학생의 정보를 입력해 주세요.");
        System.out.print("이름으로 조회하기(1) / 번호로 조회하기(2) : ");
        int chice = sc.nextInt();

        if(chice == 1){
            System.out.print("학생의 이름 : ");
            String chiceNam = sc.next();

            for(int i = 0; i < count; i++){
                if(students[i].getName().equals(chiceNam)){
                    System.out.println("조회 결과 : " + students[i].toString());
                }
            }
        } else if(chice == 2){
            System.out.print("학생의 번호 : ");
            int chiceNum = sc.nextInt();

            for(int i = 0; i < count; i++){
                if(students[i].getNumber() == chiceNum){
                    System.out.println("조회 결과 : " + students[i].toString());
                }
            }
        }
    }

    public void update(){
        System.out.print("수정할 학생의 이름을 입력하세요 : ");
        String upName = sc.next();

        for(int i = 0; i < count; i++){
            if(students[i].getName().equals(upName)){
                System.out.print("새로운 주소를 입력하세요 : ");
                String newAddress = sc.next();
                students[i].setAddress(newAddress); // 여기서 수정이 이루어짐(set은 Dto에 보면 설정된 값)
                System.out.println("학생의 주소가 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 이름의 학생을 찾을 수 없습니다.");
    }

    public void pirnt(){    // 확인용
        for(int i = 0; i < students.length; i++){
            StudentDto st = students[i];
            if(st != null){
                System.out.println(st.toString());
            }
        }
    }

    public StudentDto[] getStudents() {
        return students;
    } // student 배열이 외부에서도 접근 가능하도록 하기 위함
}
/*
    MyClass cls = new MyClass();  -> 객체 선언
    MyClass arr[] = new MyClass[3];  -> 배열 생성
    arr[0] = new MyClass();  -> 객체를 할당
    arr[1] = new MyClass();
    arr[2] = new MyClass();
 */