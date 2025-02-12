package file;

import dto.AddressDto;
import singleton.SingletonClass;

import java.io.*;

public class FileClass {
    private File file;

    public FileClass() {
        file = new File("C:\\IJ\\address.txt");
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

    public void load(){ // getter read
        String[] datas = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str = "";

            SingletonClass s = SingletonClass.getInstance();
            while((str = br.readLine()) != null){

                String data[] = str.split("-");
                String name = data[0];                  // name
                int age = Integer.parseInt(data[1]);    // age
                String phone = data[2];                 // phone
                String address = data[3];               // address
                String memo = data[4];                  // memo

                s.list.add(new AddressDto(name, age, phone, address, memo));

                // 데이터를 출력
                System.out.println("Name: " + name + ", Number: " + age + ", Phone: " + phone + ", Address: " + address + ", memo: " + memo);
            }

            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(){ // setter write
        try {
            PrintWriter pw = new PrintWriter(file);

            SingletonClass s = SingletonClass.getInstance();
            for(AddressDto dto : s.list){
                pw.println(dto.getName() + "-" + dto.getAge() + "-" + dto.getPhone() + "-" + dto.getAddress() + "-" + dto.getMemo());
            }

            pw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
