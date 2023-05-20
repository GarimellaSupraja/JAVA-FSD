package Phase1_End;
import java.util.*;

class Data {

	private int camera_id;
	private String brand;
	private String model;
	private double price;
	private boolean status;

	Data(int camera_id, String brand, String model, double price, boolean Available) {
		this.camera_id = camera_id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = Available;
	}
	
	public int getId() {
		return camera_id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getPrice() {
		return price;
	}

	public boolean isAvailable() {
		return status;
	}

	public void setAvailable(boolean Available) {
		this.status = Available;
	}
}

public class CameraRentalApp {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		System.out.println("\t\t+--------------------------------------+");
		System.out.println("\t\t|     WELCOME TO CAMERA RENTAL APP     |");
		System.out.println("\t\t+--------------------------------------+");
		
		String str= "==========================================================================";
		
		double INR = 1000;
		String username, password;
		
		System.out.println("\nPLEASE LOGIN TO CONTINUE -");
		Scanner s = new Scanner(System.in);
		System.out.print("USERNAME - ");
		username = s.nextLine();
		System.out.print("PASSWORD - ");
		password = s.nextLine();
		if (username.equals("admin") && password.equals("admin123")) {
			System.out.println("\n-----LOGIN SUCCESSFULL-----");
			ArrayList<Data> list = new ArrayList<>();
			list.add(new Data(1, "Canon", "DSLR", 1000, true));
			list.add(new Data(2, "Sony", "Ds123", 500, false));
			list.add(new Data(3, "LG", "5050", 280, true));
			list.add(new Data(4, "Lenova", "XPL", 300, true));
			list.add(new Data(5, "Nikon", "SRL", 350, true));
			list.add(new Data(6, "Sony", "2130", 260, false));
			list.add(new Data(7, "Samsung", "DL", 550, true));
			list.add(new Data(8, "LG", "Digital", 120, true));
			list.add(new Data(9, "Chroma", "108D", 330, true));
			list.add(new Data(10, "Sony", "DSLR", 2500, true));
			
			int x=0;
			do {
				int option;
				Scanner sc = new Scanner(System.in);
				
				System.out.println("\n");
				System.out.println("1.MY CAMERA");
				System.out.println("2.RENT A CAMERA");
				System.out.println("3.VIEW ALL CAMERA");
				System.out.println("4.MY WALLET");
				System.out.println("5.EXIT");
				System.out.println("Select your option : ");
				option = sc.nextInt();
				
				if(option==5) {
					System.out.println("Exiting from the CAMERA RENTAL APP...");
					break;
				}
				else if(option>5||option<1) {
					System.out.println("CHOOSE THE CORRECT OPTION AMONG - 1/2/3/4/5");
				}
				else {
					switch(option) {
					case 1:
						int y=0;
						do {
							int choose;
							System.out.println("1.ADD");
							System.out.println("2.REMOVE");
							System.out.println("3.VIEW MY CAMERA");
							System.out.println("4.GO TO PREVIOUS MENU");
							System.out.println("Enter your choice : ");
							choose = sc.nextInt();
							
							switch(choose) {
							case 1:
								System.out.print("ENTER THE CAMERA ID - ");
								int camera_id = sc.nextInt();
								System.out.print("ENTER THE CAMERA BRAND - ");
								String brand = sc.next();
								System.out.print("ENTER THE CAMERA MODEL - ");
								String model = sc.next();
								System.out.print("ENTER THE PER DAY PRICE(INR) - ");
								double price = sc.nextFloat();
								boolean Available = true;
								list.add(new Data(camera_id, brand, model, price, Available));
								System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.");
								break;
							case 2:
								System.out.println(str);
								System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(Perday)\tSTATUS");
								System.out.println(str);
								for (int i = 0; i < list.size(); i++) {
									Data data = list.get(i);
									String status = data.isAvailable() ? "Available" : "Rented";
									System.out.println(data.getId() + "\t\t" + data.getBrand() + "\t\t" + data.getModel()
											+ "\t\t" + data.getPrice() + "\t\t" + status);
								}
								System.out.println(str);
								int in=-1;
								System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
								int cameraId = sc.nextInt();
								for(int i = 0; i < list.size(); i++) {
									Data camera = list.get(i);
									if (camera.getId() == cameraId) {
										in=i;
										break;
									}
								}
								if(in!=-1) {
									Data a=list.get(in);
									if(a.getId()==cameraId) {
										list.remove(in);
										System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
										break;
									}
								}else {
									System.out.println("UNALBLE TO REMOVE");
									System.out.println("CAMERA ID "+cameraId+" IS NOT IN THE LIST");
									break;
								}
								break;
							case 3:
								System.out.println(str);
								System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(Perday)\tSTATUS");
								System.out.println(str);
								for (int i = 0; i < list.size(); i++) {
									Data data = list.get(i);
									String status = data.isAvailable() ? "Available" : "Rented";
									System.out.println(data.getId() + "\t\t" + data.getBrand() + "\t\t" + data.getModel()
											+ "\t\t" + data.getPrice() + "\t\t" + status);
								}
								System.out.println(str);
								break;
							case 4:
								x=1;
								break;
							default:
								System.out.println("INCORRECT OPTION!!");
								System.out.println("CHOOSE THE CORRECT OPTION AMONG - 1/2/3/4");
								break;
								
							}
							System.out.println("\nPress '0' to go to the previous menu / '1' to be in the same menu - ");
							y = sc.nextInt();
						}while(y==1);
						break;
					
					case 2:
						System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERS(S)");
						System.out.println(str);
						System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(Perday)\tSTATUS");
						System.out.println(str);
						for (Data data : list) {
							if (data.isAvailable()) {
								String status = data.isAvailable() ? "Available" : "Rented";

								System.out.println(data.getId() + "\t\t" + data.getBrand() + "\t\t" + data.getModel() + "\t\t"
										+ data.getPrice() + "\t\t" + status);
							}
						}
						System.out.println(str);
						int index = -1;
						System.out.println("ENTER THE CAMERA ID YOU WANT TO RENT - ");
						int cameraId = sc.nextInt();
						for (int i = 0; i < list.size(); i++) {
							Data camera = list.get(i);
							if (camera.getId() == cameraId) {
								index = i;
								break; 
							}
						}
						if (index != -1) {
							Data a = list.get(index);
							if (a.getPrice() <= INR) {
								System.out.println("YOUR TRANSACTION FOR CAMERA - "+a.getBrand()+" "+a.getModel()+" with rent INR."+a.getPrice()+" HAS SUCCESSFULLY COMPLETED");
								a.setAvailable(false);
								INR = INR - a.getPrice();
								System.out.println("CURRENT WALLET BALANCE - " + INR);
							} else {
								System.out.println("YOU DON'T HAVE SUFFICIENT BALANCE IN YOUR ACCOUNT");
							}
						} else {
							System.out.println("CAMERA WITH ID " + cameraId + " IS NOT FOUND IN THE LIST!");
						}

						break;
					case 3:
						System.out.println(str);
						System.out.println("CAMERA ID\tBRAND\t\tMODEL\t\tPRICE(Perday)\tSTATUS");
						System.out.println(str);
						for (int i = 0; i < list.size(); i++) {
							Data data = list.get(i);
							String status = data.isAvailable() ? "Available" : "Rented";
							System.out.println(data.getId() + "\t\t" + data.getBrand() + "\t\t" + data.getModel() + "\t\t"
									+ data.getPrice() + "\t\t" + status);
						}
						System.out.println(str);
						break;
					case 4:
						System.out.println("YOUR CURRENT WALLET BALANCE IS :" + INR);
						System.out.println("DO YOU WANT TO DEPOSITE MORE AMOUNT TO YOUR WALLET?(1.Yes 2.No)- ");
						int m = sc.nextInt();
						if (m == 1) {
							System.out.println("ENTER THE AMOUNT (INR) - ");
							double addAmount = sc.nextDouble();
							INR = INR + addAmount;
							System.out.print("YOUR WALLET BALANCE UPDATED SUCCESSFULLY");
						}
						System.out.println("CURRENT WALLET BALANCE - " + INR);
						break;
					default:
						System.out.println("AUTHENTICATION FAILED!");
						break;
						
					}
				}
				System.out.println("TO CONTINUE - PRESS (1.Yes 2.No) - ");
				x = sc.nextInt();
			}while(x==1);
		
		}else {
			System.out.println("AUTHENTICATION FAILED!");
			System.out.println("INVALID USER CREDENTIALS");
		}
		System.out.println("\n---THANKS FOR USING THE CAMERA RENTAL APP---");
	}
}

