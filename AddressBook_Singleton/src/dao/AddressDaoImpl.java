package dao;

import dto.AddressDto;
import file.FileClass;
import singleton.SingletonClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressDaoImpl implements AddressDao{
    Scanner sc = new Scanner(System.in);

    private FileClass fc;

    public AddressDaoImpl() {

        fc = new FileClass();
        fc.create();
    }

    @Override
    public void insert() {
        System.out.println("추가입니다 >>");
        System.out.print("이름 = ");
        String name = sc.next();

        System.out.print("나이 = ");
        int age = sc.nextInt();

        System.out.print("전화번호 = ");
        String phone = sc.next();

        System.out.print("주소 = ");
        String address = sc.next();

        System.out.print("메모 = ");
        String memo = sc.next();

        SingletonClass s = SingletonClass.getInstance();
        s.list.add(new AddressDto(name, age, phone, address, memo));
        // 싱글턴 안에있는 list란 의미
    }

    @Override
    public void delete() {
        System.out.println("삭제입니다 >>");
        System.out.print("이름 = ");
        String name = sc.next();

        int index = search(name);

        if(index == -1){
            System.out.println("목록에서 찾을 수 없습니다");
            return;
        }

        SingletonClass s = SingletonClass.getInstance();
        AddressDto removeDto = s.list.remove(index);
        System.out.println(removeDto.getName() + "의 데이터를 삭제했습니다");
    }

    @Override
    public void update() {
        System.out.println("수정입니다 >>");
        System.out.print("이름 = ");
        String name = sc.next();

        int index = search(name);

        if(index == -1){
            System.out.println("목록에서 찾을 수 없습니다");
            return;
        }

        // 확인
        SingletonClass s = SingletonClass.getInstance();
        System.out.println(s.list.get(index));

        System.out.print("수정하실 주소 = ");
        String address = sc.next();

        s.list.get(index).setAddress(address);
        System.out.println("수정되었습니다");
    }

    @Override
    public void nameSelect() {
        List<AddressDto> findList = new ArrayList<>();

        System.out.println("이름검색입니다 >>");
        System.out.print("이름 = ");
        String name = sc.next();

        SingletonClass s = SingletonClass.getInstance();
        for (AddressDto dto : s.list){
            if(name.equals(dto.getName())){
                findList.add(dto);
            }
        }

        if(findList.isEmpty()){
            System.out.println("명단에 없습니다");
        }

        for (AddressDto dto : findList){
            System.out.println(dto.toString());
        }
    }

    @Override
    public void addressSelect() {
        List<AddressDto> findList = new ArrayList<>();

        System.out.println("주소검색입니다 >>");
        System.out.print("주소 = ");
        String address = sc.next();

        SingletonClass s = SingletonClass.getInstance();
        for (AddressDto dto : s.list){
            if(dto.getAddress().contains(address)){ // contains : 특정문자열을 포함하는 여부를 판별하는 함수
                findList.add(dto);
            }
        }

        if(findList.isEmpty()){
            System.out.println("명단에 없습니다");
        }
        for (AddressDto dto : findList){
            System.out.println(dto.toString());
        }
    }

    @Override
    public void memoSelect() {
        List<AddressDto> findList = new ArrayList<>();

        System.out.println("메모검색입니다 >>");
        System.out.print("검색어 = ");
        String memo = sc.next();

        SingletonClass s = SingletonClass.getInstance();
        for (AddressDto dto : s.list){
            if(dto.getMemo().contains(memo)){
                findList.add(dto);
            }
        }

        for (AddressDto dto : findList){
            System.out.println(dto);
        }
    }

    public int search(String name){
        int index = -1;
        SingletonClass s = SingletonClass.getInstance();

        for (int i = 0;i < s.list.size(); i++){
            AddressDto dto = s.list.get(i);
            if(name.equals(dto.getName())){
                index = i;
                break;
            }
        }
        return index;
    }

    public void all(){
        SingletonClass s = SingletonClass.getInstance();
        for (AddressDto dto : s.list){
            System.out.println(dto.toString());
        }
    }

    @Override
    public void dataSave() {
        fc.save();
    }
// 싱글턴을 사용하면 리스트에 바로 접근이 가능하기 때문에
// fileClass에서 바로 접근 가능함(그래서 여기선 호출만 해주면 됨)
    @Override
    public void dataLoad() {
        fc.load();
    }
}
