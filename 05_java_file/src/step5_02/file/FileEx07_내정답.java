package step5_02.file;
//2021/04/12 14:00 ~ 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[2단계] : ATM

public class FileEx07_내정답 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int size = 5;
		int accsCnt = 0;
		int identifier = -1;
		
		String[] accs = new String[size];
		String[]  pws = new String[size];
		int[]  moneys = new int[size];
		
		String fileName = "atm.txt";
		
		while(true) {
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1) {
				
				System.out.println("[가입] 계좌번호 입력: ");
				String acc = scan.next();
				
				int check = 1;
				
				for (int i=0; i<accsCnt; i++) {
					if(accs[i].equals(acc)) {
						check = -1;
					}
				} 
				
				if(check ==1) {
					if(accsCnt == 5) {
						System.out.println("[메세지] 더이상 가입할 수 없습니다.");
					 continue;
					}
				
					System.out.println("[가입] 패스워드 입력: ");
					String pw = scan.next();
					
					accs[accsCnt] = acc;
					pws[accsCnt] = pw;
					moneys[accsCnt] = 1000;
					
					accsCnt ++;
					System.out.println("[메게지] 회원가입을 축하합니다.");
				}
				else {
					System.out.println("[메시지] 계좌번호가 중복됩니다.");
				}
			}
			
			else if (sel == 2) {
				if(identifier != -1) {
					for(int i=identifier; i<accsCnt-1; i++) {
						accs[i] = accs[i+1];
						pws[i] = pws[i+1];
						moneys[i] = moneys[i+1];
					}
					accsCnt--;
					identifier = -1;
					System.out.println("[메세지] 탈퇴되었습니다.");
				}
				else {
					System.out.println("[메세지] 로그인 후 이용 가능합니다.");
				}
			}
			
			else if (sel == 3) {
				if(identifier == -1) {
					System.out.println("[로그인] 계좌번호 입력: ");
					String acc = scan.next();
					
					System.out.println("[로그인] 비밀번호 입력: ");
					String pw = scan.next();
					
					for(int i=0; i<accsCnt; i++) {
						if(accs[i].equals(acc) && pws[i].equals(pw)) {
							identifier = i;
						}
					}
					if(identifier == -1) {
						System.out.println("[메세지] 계좌번호와 비밀번호를 확인해주세요.");
					}
				}
				else {
					System.out.println("[메시지]" + accs[identifier] + "님 로그인중..");
				}
			}
			
			else if (sel == 4) {
				if(identifier == -1) {
					System.out.println("[메세지] 로그인 후 이용이 가능합니다.");
				}
				else {
					identifier = -1;
					System.out.println("[메세지] 로그아웃 되었습니다.");
				}
			}
			
			else if (sel == 5) {
				if(identifier != -1) {
					System.out.print("[입금] 금액 입력: ");
					int money = scan.nextInt();
					moneys[identifier] += money;
					System.out.println("[메세지] 입금이 완료되었습니다");
				}
				else {
					System.out.println("[메세지] 로그인 후 이용 가능합니다.");
				}
			}
			
			else if (sel == 6) {
				if(identifier != -1) {
					System.out.print("[출금] 금액 입력: ");
					int money = scan.nextInt();
					
					if(moneys[identifier] >= money) {
						moneys[identifier] -= money;
						System.out.println("[메세지] 출금을 완료하였습니다.");
					}
				}
				else {
					System.out.println("[메세지] 로그인 후 이용이 가능합니다.");
				}
			}
			
			else if (sel == 7) {
				if(identifier != 1) {
					System.out.println("[이체] 계좌번호 입력: ");
					String acc = scan.next();
					
					int check = -1;
					for(int i=0; i<accsCnt; i++) {
						if(accs[i].equals(acc)) {
							check = i;
						}
					}
					if(check != -1) {
						System.out.print("[이체] 금액입력: ");
						int money = scan.nextInt();
						if(moneys[identifier] >= money) {
							moneys[identifier] -= money;
							moneys[check] += money;
							System.out.println("[메세지] 이체를 완료하였습니다.");
						
						}
						else {
							System.out.println("[메세지] 잔액이 부족합니다.");
						}
					}
					else {
						System.out.println("[메세지] 계좌번호를 확인해주세요.");
					}
				}
				else {
					System.out.println("[메세지] 로그인 후 이용이 가능합니다.");
				}
			}
			
			else if (sel == 8) {
				if(identifier != -1) {
					System.out.println(accs[identifier] + "님의 계좌 잔액은" + moneys[identifier] + "원 입니다.");
				}
				else {
					System.out.println("[메세지] 로그인 후 이용 가능합니다.");
				}
			}
			else if (sel == 9) {
				 if(accsCnt == 0) {
					 System.out.println("[메세지] 저장할 데이터가 없습니다.");
					 continue;
				 }
				 
				 String data = "";
				 for(int i=0; i<accsCnt; i++) {
					 data += accs[i];
					 data += "/";
					 data += pws[i];
					 data += "/";
					 data += moneys[i];
					 data += "\n";
					 
				 }
				 
				 data = data.substring(0, data.length()-1);
				 
				 FileWriter fw = null;
				 
				 try {
					 fw = new FileWriter(fileName);
					 fw.write(data);
				 } catch(Exception e) {
					 e.printStackTrace();
				 } finally {
					 if(fw != null) {try {fw.close();} catch(IOException e) {e.printStackTrace();}}
				 }
			}
			
			else if (sel == 10) {
				File file = new File(fileName);
				
				if(file.exists()) {
					FileReader fr = null;
					BufferedReader br = null;
					
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						String data = "";
						
						while (true) {
							String line = br.readLine();
							if(line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data =  data.substring(0, data.length()-1);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			else if (sel == 0) {
				break;
			}
			
		}
		
	}
}
