package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PhoneDao pDao = new PhoneDao();
		List<PersonVo> phoneList = pDao.getPersonList();
		
		int num, personId;
		String name, hp, company, str;
		
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("-----------------------------------------");
			System.out.print(">> 메뉴번호 : ");
			
			num = sc.nextInt();
			
			//프로그램 종료
			if (num == 6) {
				System.out.println("******************************************");
				System.out.println("*               감사합니다               *");
				System.out.println("******************************************");
				break;
			} else
			//리스트 출력(select)
			if (num == 1) {
				//리스트 출력
				System.out.println("< 1. 리스트 >");
				phoneList = pDao.getPersonList();
				
				for(int i = 0; i < phoneList.size(); i++) {
					PersonVo pvo  = phoneList.get(i);
					System.out.println(pvo.getPersonId() + ".\t" + pvo.getName() + "\t" +
									   pvo.getHp() + "\t" + pvo.getCompany());
				}
				System.out.println("");
			} else
			//등록(insert)
			if (num == 2) {
				System.out.println("< 2. 등록 >");
				
				System.out.print("이름 >> ");
				name = sc.next();
				
				System.out.print("휴대전화 >> ");
				hp = sc.next();
				
				System.out.print("회사번호 >> ");
				company = sc.next();
				
				PersonVo pvo = new PersonVo(name, hp, company);
				pDao.personInsert(pvo);
				
				System.out.println("");
			} else
			//수정(update)
			if(num == 3) {
				System.out.println("< 3. 수정 >");
				
				System.out.print("번호 >> ");
				personId = sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("이름 >> ");
				name = sc.next();
				
				System.out.print("휴대전화 >> ");
				hp = sc.next();
				
				System.out.print("회사번호 >> ");
				company = sc.next();
				
				PersonVo pvo = new PersonVo(personId, name, hp, company);
				pDao.personUpdate(pvo);
			} else
			//삭제(delete)
			if(num == 4) {
				System.out.println("< 4. 삭제 >");
				
				System.out.print("번호 >> ");
				personId = sc.nextInt();
				
				pDao.personDelete(personId);
			} else 
			//검색(search)
			if(num == 5) {
				System.out.println("< 5. 검색 >");
				
				System.out.print("검색어 >> ");
				sc.nextLine();
				str = sc.next();
				
				if(str.length() > 0) {
					phoneList = pDao.personSearch(str);
					
					for(int i = 0; i < phoneList.size(); i++) {
						PersonVo pvo = phoneList.get(i);
						System.out.println(pvo.getPersonId() + ".\t" + pvo.getName() + "\t" +
								   pvo.getHp() + "\t" + pvo.getCompany());
					}
					System.out.println("");
				} else {
					System.out.println("검색어를 입력해주세요.");
				}
			} else {
				System.out.println("[ 다시 입력해주세요.] ");
				System.out.println("");
			}
		}
		
		sc.close();
	}

}
