package file;

import dto.StudentDto;

import java.io.*;

public class FileClass {

    private File file;

    public FileClass() {
        file = new File("C:\\IJ\\text.txt");
    }
    public void create(){ // 파일
        try {
            if(file.createNewFile()){
                System.out.println("파일 생성 성공!");
            }else{
                System.out.println("같은 파일명이 존재합니다");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] load(){ // getter read
        String[] datas = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // 데이터의 갯수
            int count = 0;
            String str = "";
            while((str = br.readLine()) != null){
                count++;
            }
            br.close();

            // datas의 배열을 할당
            datas = new String[count];

            // 데이터를 파일로부터 저장
            br = new BufferedReader(new FileReader(file));
            int len = 0;
            while((str = br.readLine()) != null){
                datas[len] = str;
                len++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return datas;
    }

    public void save(String[] datas){ // setter write
        // 1-홍길동-171.2-서울시  [0]        row
        // 2-성춘향-159.3-남원시  [1]
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            for (String s : datas){
                if(s != null) {
                    pw.println(s);
                }
            }
            pw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
