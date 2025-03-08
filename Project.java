package project;
import java.util.*;

class DataBase {
    public String car, number, price, status;
    Scanner sc = new Scanner(System.in);
    public int i = -1;
    DataBase d[] = new DataBase[50];
    
    String adhar,pan,Drivinglicense;
    
    void validAdhar() {
        String a = sc.nextLine();
        if (a.length() == 12) {
            adhar = a;
        } else {
            System.out.println("\nINVALID ADHAR NUMBER\n\nENTER AGAIN :");
            validAdhar();
        }
    }

    void validPan() {
        int c = 0;
        String a = sc.nextLine();
        for (int p = 0; p < a.length(); p++) {
            if (((65 <= (int) a.charAt(p)) && ((int) a.charAt(p) <= 90)) || ((97 <= (int) a.charAt(p)) && ((int) a.charAt(p) <= 122)))
                c++;
        }
        if (c == 6 && a.length() == 10) {
            pan = a;
        } else {
            System.out.println("\nINVALID PAN NUMBER\n\nENTER AGAIN :");
            validPan();
        }
    }

    void validLicense() {
        String a = sc.nextLine();

        if (a.length() != 15) {
            System.out.println("\nINVALID LICENSE NUMBER.\n\nENTER AGAIN :");
            validLicense();
            return;
        }

        if (!Character.isLetter(a.charAt(0)) || !Character.isLetter(a.charAt(1))) {
            System.out.println("\nINVALID LICENSE NUMBER\n\nENTER AGAIN :");
            validLicense();
            return;
        }
        String stateCode = a.substring(0, 2).toUpperCase();
        String stateCodes[] = {"AP", "AR", "AS", "BR", "CG", "GA", "GJ", "HR", "HP", "JK", "JH", "KA", "KL", "MP", "MH", "MN", "ML", "MZ", "NL", "OD", "PB", "RJ", "SK", "TN", "TS", "TR", "UK", "UP", "WB"};
        boolean validStateCode = false;
        for (String code : stateCodes) {
            if (code.equals(stateCode)) {
                validStateCode = true;
                break;
            }
        }

        if (!validStateCode) {
            System.out.println("\nINVALID LICENSE NUMBER. The state code is not valid for Indian states.");
            validLicense();
            return;
        }

        Drivinglicense = a;
    }
    
    public void bookACab() {
        System.out.print("\n ENTER ADHAR NUMBER :- ");
        validAdhar();
        System.out.print("\n ENTER PAN NUMBER :- ");
        validPan();
        System.out.print("\n ENTER LICENSE NUMBER :- ");
        validLicense();
        System.out.print("\n\n  VERIFIED ALL DETAILS\n\n ");
        
        System.out.print("\n\n  CAB NAME : ");
        String cab = sc.nextLine();
        for (int j = 0; j <= i; j++) {
            if(d[j].car.equals(cab) && d[j].status.equals("AVIABLE")) {
                d[j].status = "BOOKED";
                System.out.println("\n\nCAR BOOKED FOR A DAY \n PRICE TO PAY -> " + d[j].price);
                return;
            }
        }
        System.out.println("\n\nUNABLE TO BOOK ONCE CHECK CAR NAME AND STATUS .......\n\n");        
    }

    public void newCar() {
        i = i + 1;
        d[i] = new DataBase();
        System.out.print("ENTER CAR NAME : ");
        d[i].car = sc.nextLine();
        System.out.print("ENTER CAR NUMBER : ");
        d[i].number = sc.nextLine();
        System.out.print("ENTER RENTAL PRICE PER DAY : ");
        d[i].price = sc.nextLine();
        d[i].status = "AVIABLE";
    }

    public String toString() {
        return ("\n ➡️[ MODEL ] -> ( " + car + " )[ "+status+" ] [PRICE PER DAY] -> ( " + price+" )\n");
    }

    public void allCars() {
        if (i == -1) {
            System.out.println("NO CABS ARE PRESENT TO BOOK");
            return;
        }
        for (int j = 0; j <= i; j++) {
            System.out.println(d[j]);
        }
    }
}

public class Project extends DataBase {

    public void newCab() {
        newCar(); 
    }

    public static void main(String[] args) {
        Project P = new Project(); 
        int c;
        System.out.println("\nWELCOME TO CAB SERVICES 😊\n");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("ENTER < 1 > TO ENTER A CAB 🚔");
            System.out.println("ENTER < 2 > TO BOOK A CAB 🚓");
            System.out.println("ENTER < 3 > TO CHECK AVAILABLE CABS 🚕");
            System.out.println("ENTER < 4 > TO EXIT CAB SERVICES 🥲");
            System.out.print("ENTER A CASE :- ");
            c = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (c) {
                case 1:
                    P.newCab();
                    break;

                case 2:
                    P.bookACab();
                    break;

                case 3:
                    P.allCars();
                    break;

                case 4:
                    System.out.println("\n\n\nTHANK YOU FOR USING CAB SERVICES");
                    break;

                default:
                    System.out.println("\n\nREENTER CORRECT CASE \n\n");
            }

        } while (c != 4);

        sc.close();
    }
}



