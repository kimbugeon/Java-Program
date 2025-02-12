package dao;

import dto.AddressDto;
import file.FileClass;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDao {

    private Scanner sc;
    private List<AddressDto> list;
    private FileClass fileDao;

    public AddressDao() {
        sc = new Scanner(System.in);
        list = new ArrayList<AddressDto>();
        fileDao = new FileClass();
        fileDao.create();
    }

    public void insert(){
        System.out.println("정보를 입력해주세요.");
        System.out.print("이름 : ");
        String name = sc.next();

        System.out.print("나이 : ");
        int number = sc.nextInt();

        System.out.print("전화번호 : ");
        String phone = sc.next();

        System.out.print("주소 : ");
        String address = sc.next();

        System.out.print("메모 : ");
        String note = sc.next();

        AddressDto adto = new AddressDto(name, number, phone, address, note);
        list.add(adto);
    }

    public void delete(){
        boolean loopStop = true;

        while(loopStop) {
            System.out.print("삭제할 주소 이름으로 검색 : ");
            String name = sc.next();

            int index = search(name);

            if (index == -1) {
                System.out.println("입력한 이름을 찾을 수 없습니다. 다시 입력하세요.");
                continue;
            }
            list.remove(index);
            System.out.println("주소를 삭제하였습니다.");
            loopStop = false;
        }
    }

    public void select(){
        System.out.print("검색 정보를 선택하세요. 이름(1)/주소(2)/메모(3) : ");
        int choice = sc.nextInt();

        System.out.print("정보를 입력하세요 : ");
        String strData = sc.next();

        List<AddressDto> result = new ArrayList<AddressDto>();

        // list : 반복하고자 하는 컬렉션
        // list의 각 요소를 AddressDto 타입의 변수 dto에 하나씩 할당
        for(AddressDto dto : list){
            switch (choice){
                case 1:
                    if(dto.getName().contains(strData)){
                        result.add(dto);
                    }
                    break;
                case 2:
                    if(dto.getAddress().contains(strData)){
                        result.add(dto);
                    }
                    break;
                case 3:
                    if(dto.getNote().contains(strData)){
                        result.add(dto);
                    }
                    break;
                default:
                    System.out.println("올바른 숫자를 입력해주세요.");
                    return;
            }
        }
        if(result.isEmpty()){
            System.out.println("검색된 결과가 없습니다.");
        } else {
            System.out.println("검색 결과");
            for(AddressDto dto : result){
                System.out.print(dto + "\n");
            }
        }
    }

    public void update(){
        System.out.print("수정할 주소 이름으로 검색 : ");
        String name =sc.next();

        int index = search(name);
        if(index == -1){
            System.out.println("찾을 수 없는 정보입니다.");
            return;
        }
        System.out.println("입력한 이름의 정보");
        System.out.print(list.get(index).toString() + "\n");

        System.out.print("수정할 주소를 입력하세요 : ");
        String address = sc.next();

        AddressDto dto = list.get(index);
        dto.setAddress(address);
        System.out.println("수정이 완료되었습니다.");
    }

    public void print(){
        for(AddressDto s : list){
            System.out.println(s.toString());
        }
    }

    public int search(String name){
        int index = -1;

        for(int i = 0; i < list.size(); i++){
            AddressDto dto = list.get(i);
            if(name.equals(dto.getName())){
                index = i;
                break;
            }
        }
        return index;
    }

    public void dataLoad(){
        String datas[] = fileDao.load();

        for(int i = 0; i < datas.length; i++){
            String data[] = datas[i].split("-");

            String name = data[0];
            int number = Integer.parseInt(data[1]);
            String phone = data[2];
            String address = data[3];
            String note = data[4];

            AddressDto dto = new AddressDto(name, number, phone, address, note);
            list.add(dto);

            // 데이터를 출력
            System.out.println("Name: " + name + ", Number: " + number + ", Phone: " + phone + ", Address: " + address + ", Note: " + note);
        }
    }

    public void dataSave(){
        String datas[] = new String[50];

        int len = 0;
        for(int i = 0; i < list.size(); i++){
            AddressDto dto = list.get(i);
            datas[len] = dto.getName() + "-" + dto.getNumber() + "-" + dto.getPhone() + "-" + dto.getAddress() + "-" + dto.getNote();
            len++;
        }
        fileDao.save(datas);
    }
}