package dao;

import dto.HouseHoldDto;
import file.FileClass;
import singleton.SingletonClass;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HouseHoldDaoImpl implements HouseHoldDao{

    private Scanner sc;
    private FileClass fileDao;

    public HouseHoldDaoImpl() {

        sc = new Scanner(System.in);
        fileDao = new FileClass();
    }

    public void insert() {
        System.out.println("날짜 - 수입 - 지출 - 메모 순으로 작성해주세요.");
        System.out.print("날짜(yyyy-mm-dd) : ");
        String month = sc.next();

        System.out.print("수입 : ");
        String income = sc.next();

        System.out.print("지출 : ");
        String outlay = sc.next();

        System.out.print("메모 : ");
        String memo = sc.next();

        SingletonClass single = SingletonClass.getInstance();
        single.list.add(new HouseHoldDto(month, income, outlay, memo));
    }

    public void delete(){

        boolean loopStop = true;

        System.out.println("삭제할 날짜를 입력해주세요.");
        while(loopStop) {
            System.out.print("날짜(yyyy-mm-dd) : ");
            String month = sc.next();

            int index = search(month);

            if (index == -1) {
                System.out.println("해당 날짜는 찾을 수 없습니다. 다시 입력해주세요.");
                continue;
            }

            SingletonClass s = SingletonClass.getInstance();
            HouseHoldDto removeDto = s.list.remove(index);
            System.out.println(removeDto.getMonthly() + "의 날짜를 삭제하였습니다.");
            loopStop = false;
        }
    }

    public void select(){
        System.out.println("검색할 기간을 입력해주세요.");
        System.out.print("시작 날짜(yyyy-mm-dd) : ");
        String startMonth = sc.next();

        System.out.print("종료 날짜(yyyy-mm-dd) : ");
        String endMonth = sc.next();


        try {
            LocalDate start = LocalDate.parse(startMonth);
            LocalDate end = LocalDate.parse(endMonth);

            if (start.isAfter(end)) {
                System.out.println("시작 날짜는 종료 날짜보다 이전이어야 합니다.");

                return;
            }

            SingletonClass single = SingletonClass.getInstance();
            boolean loopStop = false;

            System.out.println("검색된 결과 : ");
            for (HouseHoldDto dto : single.list) {
                LocalDate dtoMonth = LocalDate.parse(dto.getMonthly());

                if ((dtoMonth.isEqual(start) || dtoMonth.isAfter(start)) &&
                        (dtoMonth.isEqual(end) || dtoMonth.isBefore(end))) {
                    System.out.println(dto);
                    loopStop = true;
                }
            }
            if (!loopStop) {
                System.out.println("지정한 기간 내 데이터가 없습니다.");
            }
        } catch (Exception e){
            System.out.println("날짜 형식이 올바르지 않습니다. yyyy-mm-dd 형식으로 입력해주세요.");
        }
    }

    public void bottom(){
        System.out.println("결산 방법을 선택해주세요.");
        System.out.println("월별 결산(1), 지정기한 내 결산(2)");
        System.out.print("선택 : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sumBot();
                break;
            case 2:
                selBot();
                break;
            default:
                System.out.println("올바른 메뉴는 선택하십시오.");
        }
    }

    private void sumBot(){
        SingletonClass single = SingletonClass.getInstance();
        Map<String, int[]> sumBot = new HashMap<>();

        for(HouseHoldDto dto : single.list){
            String month = dto.getMonthly().substring(0, 7); // yyyy-mm 까지 추출
            int income = Integer.parseInt(dto.getIncome());
            int outlay = Integer.parseInt(dto.getOutlay());

            sumBot.putIfAbsent(month, new int[2]);  // 키가 없을 때만 추가(덮어쓰지않음)
            int[] value = sumBot.get(month);
            value[0] = value[0] + income;
            value[1] = value[1] + outlay;
        }
        System.out.println("월별 결산 : ");
        for(String months : sumBot.keySet()){
            int values[] = sumBot.get(months);
            int incomes = values[0];
            int outlays = values[1];
            System.out.printf("%s - 수입 : %d, 지출 : %d, 잔액 : %d\n", months, incomes, outlays, incomes - outlays);
        }
    }

    private void selBot(){
        System.out.println("기간을 지정해주세요.");
        System.out.print("시작 날짜(yyyy-mm-dd) : ");
        String startMonth = sc.next();

        System.out.print("종료 날짜(yyyy-mm-dd) : ");
        String endMonth = sc.next();


        try {
            LocalDate start = LocalDate.parse(startMonth);
            LocalDate end = LocalDate.parse(endMonth);

            if (start.isAfter(end)) {
                System.out.println("시작 날짜는 종료 날짜보다 이전이어야 합니다.");
                return;
            }

            SingletonClass single = SingletonClass.getInstance();
            int totalIn = 0;
            int totalOut = 0;

            for (HouseHoldDto dto : single.list) {
                LocalDate dtoDate = LocalDate.parse(dto.getMonthly());
                if ((dtoDate.isEqual(start) || dtoDate.isAfter(start)) &&
                        (dtoDate.isEqual(end) || dtoDate.isBefore(end))) {
                    totalIn += Integer.parseInt(dto.getIncome());
                    totalOut += Integer.parseInt(dto.getOutlay());
                }
            }
            System.out.println("지정한 기간 내 결산 : ");
            System.out.printf("수입 : %d, 지출 : %d, 잔액 : %d\n", totalIn, totalOut, totalIn - totalOut);

        } catch (Exception e) {
            System.out.println("날짜 형식이 올바르지 않습니다. yyyy-MM-dd 형식으로 입력해주세요.");
        }

    }

    public void update(){
        System.out.println("수정할 날짜를 입력해주세요.");
        System.out.print("날짜(yyyy-mm-dd) : ");
        String month = sc.next();

        int index = search(month);

        if(index == -1){
            System.out.println("날짜를 조회할 수 없습니다.");
            return;
        }
        SingletonClass s = SingletonClass.getInstance();
        System.out.println("조회한 날짜의 정보");
        System.out.println(s.list.get(index).toString() + "\n");

        System.out.println("수정할 항목을 선택해주세요.");
        System.out.println("날짜(1), 수입(2), 지출(3)");
        System.out.print("선택 : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("수정할 날짜(yyyy-mm-dd): ");
                String newMonth = sc.next();
                s.list.get(index).setMonthly(newMonth);
                System.out.println("날짜가 수정되었습니다.");
                break;

            case 2:
                System.out.print("수정할 수입: ");
                String newIncome = sc.next();
                s.list.get(index).setIncome(newIncome);
                System.out.println("수입이 수정되었습니다.");
                break;

            case 3:
                System.out.print("수정할 지출: ");
                String newoutlay = sc.next();
                s.list.get(index).setOutlay(newoutlay);
                System.out.println("지출이 수정되었습니다.");
                break;

            default:
                System.out.println("올바르지 않은 선택입니다.");
        }

    }

    public int search(String name){
        int index = -1;
        SingletonClass s = SingletonClass.getInstance();

        for (int i = 0;i < s.list.size(); i++){
            HouseHoldDto dto = s.list.get(i);
            if(name.equals(dto.getMonthly())){
                index = i;
                break;
            }
        }
        return index;
    }

    public void print(){
        SingletonClass single = SingletonClass.getInstance();
        for(HouseHoldDto dto : single.list){
            System.out.println(dto.toString());
        }
    }

    public void dataLoad(){
        fileDao.load();
    }

    public void dataSave(){;
        fileDao.create();
        fileDao.save();
    }
}
