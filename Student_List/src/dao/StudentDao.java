package dao;

import dto.StudentDto;
import file.FileClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Data Access Object
public class StudentDao {
    // CRUD
    private Scanner sc;
    private List<StudentDto> list;
    private FileClass fc; // FileClass 객체 선언

    public StudentDao() {
        sc = new Scanner(System.in);
        list = new ArrayList<StudentDto>();
        fc = new FileClass();
        fc.create();   // 파일 생성
    }

    public void insert(){   // 추가
        System.out.println("학생추가 >>>" );
        System.out.print("번호 = ");
        int number = sc.nextInt();

        System.out.print("이름 = ");
        String name = sc.next();

        System.out.print("키 = ");
        double height = sc.nextDouble();

        System.out.print("주소 = ");
        String address = sc.next();

        StudentDto dto = new StudentDto(number, name, height, address);
        list.add(dto);
    }

    public void delete(){   // 삭제
        System.out.println("학생삭제 >>>" );
        System.out.print("학생명 = ");
        String name = sc.next();

        // 검색
        // index를 찾아서 삭제하는 방법
        int index = search(name);

        // 삭제
        if(index == -1){
            System.out.println("학생정보를 찾을 수 없습니다");
            return;
        }
        list.remove(index);

        System.out.println("학생데이터를 삭제하였습니다");
    }

    public void select(){   // 검색
        System.out.println("학생검색 >>>" );
        System.out.print("학생명 = ");
        String name = sc.next();

        int index = search(name);

        if(index == -1){
            System.out.println("학생정보를 찾을 수 없습니다");
            return;
        }

        System.out.println("학생정보입니다 >> ");
        StudentDto dto = list.get(index);
        System.out.println(dto.toString());
    }

    public void update(){   // 수정
        System.out.println("학생정보수정 >>>" );
        System.out.print("학생명 = ");
        String name = sc.next();

        int index = search(name);
        if(index == -1){
            System.out.println("학생정보를 찾을 수 없습니다");
            return;
        }

        System.out.println("학생정보입니다 >> ");
        System.out.println(list.get(index).toString());

        System.out.print("수정할 주소를 입력 = ");
        String address = sc.next();

        StudentDto dto = list.get(index);
        dto.setAddress(address);
        System.out.println("수정되었습니다");
    }

    public int search(String name){
        int index = -1;

        for(int i = 0; i < list.size(); i++){
            StudentDto dto = list.get(i);
            if(name.equals(dto.getName())){
                index = i;
                break;
            }
        }
        return index;
    }

    public void print(){
        for(StudentDto s : list){
            System.out.println(s.toString());
        }
    }

    public void dataLoad(){
        String datas[] = fc.load();

        for(int i = 0;i < datas.length; i++) {
            String[] data = datas[i].split("-");
            int number = Integer.parseInt(data[0]);     // 1
            String name = data[1];                      // 홍길동
            double height = Double.parseDouble(data[2]);    // 171.2
            String address = data[3];                   // 서울시

            StudentDto st = new StudentDto(number, name, height, address);
            list.add(st);

            // 데이터를 출력
            System.out.println("Number: " + number + ", Name: " + name + ", height: " + height + ", Address: " + address);
        }
    }

    public void dataSave(){
        String datas[] = new String[10];

        int len = 0;
       /*
        for(int i = 0; i < list.size(); i++){
           StudentDto dto = list.get(i);
           datas[len] = dto.getNumber() + "-" + dto.getName() + "-" + dto.getHeight() + "-" + dto.getAddress();
           len++;
        }
        */
        for(StudentDto s : list){
            datas[len] = s.getNumber() + "-" + s.getName() + "-" + s.getHeight() + "-" + s.getAddress();
            len++;
        }
        fc.save(datas);
    }
}