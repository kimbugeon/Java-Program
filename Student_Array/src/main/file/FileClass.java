package main.file;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import main.dto.StudentDto;

import java.io.IOException;

public class FileClass {

    private File file;
    private Scanner sc;
    private StudentDto[] students; // 배열 선언

    public FileClass(StudentDto[] students) {
        this.sc = new Scanner(System.in);
        this.students = students; // 전달받은 students[]배열을 내부 필드에 저장

    }

    public void create() throws IOException {
        System.out.print("사용할 파일명을 입력하세요 : ");
        String fileName = sc.next();
        file = new File("C:\\IJ\\" + fileName + ".txt");

        if(file.createNewFile()){
            System.out.println(fileName + "파일생성 완료");
        } else {
            System.out.println(fileName + "파일명이 존재합니다.");
        }
    }

    public void load(){
        System.out.print("읽어올 파일명을 입력하세요 : ");
        String fileName = sc.next();
        File fileLoad = new File("C:\\IJ\\" + fileName + ".txt");

        try{
           FileReader fr = new FileReader(fileLoad);
           BufferedReader br = new BufferedReader(fr);

           int countData = 0;
           String str = "";
           while((str = br.readLine()) != null){
               countData++;
           }

           fr = new FileReader(fileLoad);
           br = new BufferedReader(fr);

           String nameArr[] = new String[countData];
           int index = 0;
           while((str = br.readLine()) != null){
               nameArr[index] = str;
               index++;
           }
           br.close();

           System.out.println(Arrays.toString(nameArr));
       } catch(IOException e){
           throw new RuntimeException(e);
       }
    }

    public void save() {

        if (file == null) { // file 변수가 참조가 없는 상태인지 확인(즉, 파일 이름을 찾았는데 없다는 뜻. 그래서 저장을 못한다.)
            System.out.println("파일이 생성되지 않았습니다. 먼저 파일을 생성해주세요.");
            return; // 파일이 생성되지 않았다면 저장을 하지 않음
        }

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    String studentData = students[i].getNumber() + "," +
                                         students[i].getName() + "," +
                                         students[i].getHeight() + "," +
                                         students[i].getAddress();
                    pw.write(studentData);
                    pw.println();
                }
            }
            pw.close();

            System.out.println("학생 정보가 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }

}
