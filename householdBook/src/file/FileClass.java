package file;

import dto.HouseHoldDto;
import singleton.SingletonClass;
import java.io.*;
import java.util.Scanner;

public class FileClass {

    private File file;

    public FileClass() {
        file = new File("C:\\IJ\\가계부 관리.txt");
    }

    public void create(){
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

    public void load(){
        String[] datas = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str = "";

            SingletonClass s = SingletonClass.getInstance();
            while((str = br.readLine()) != null){

                String data[] = str.split("-");
                String monthly = data[0] + "-" + data[1] + "-" + data[2];
                String income = data[3];
                String outlay = data[4];
                String memo = data[5];

                s.list.add(new HouseHoldDto(monthly, income, outlay, memo));

                // 데이터를 출력
                System.out.println("monthly: " + monthly + ", income: " + income + ", outlay: " + outlay + ", memo: " + memo);
            }

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(){
        try {
            PrintWriter pw = new PrintWriter(file);

            SingletonClass s = SingletonClass.getInstance();
            for(HouseHoldDto dto : s.list){
                pw.println(dto.getMonthly() + "-" + dto.getIncome() + "-" + dto.getOutlay() + "-" + dto.getMemo());
            }

            pw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
