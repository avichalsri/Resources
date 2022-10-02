/*
 * Candy shop using Java 
 * - In the shop user will have the following options:
 * *** Welcome to candy Shop ***
 * To select an item,enter
 * 1 for Candy 
 * 2 for Chips 
 * 3 for Gum 
 * 4 for Cookies
 * 9 for exit
 * - the shop will have limited amount of stock for each item and user can only buy upto the quantity the item is in stock 
 * - user receives a error message if the item is out of stock
 * - after selecting the item per item price and total amount to be deposited by user is shown
 * - user has to enter the amount
 * - if the amount entered is less, user is asked to enter the remaining amount 
 * - if the amount is more, user is returned the remaining amount
 * - when shop is exit remaining stock of items is shown along with the total amount collected
 */

import java.util.Scanner;
class integers {
    int a;
    integers(int x) {
        a = x;
    }
}
class candyshop {
    static void update(integers aval, integers bal, int quantity, int price) {
        Scanner scan = new Scanner(System.in);
        if (aval.a == 0) {
            System.out.println("Sorry this item is sold out");
        } else if (quantity > aval.a) {
            System.out.println("Only " + aval.a + " peices are available");
        } else {
            System.out.println("price per product:Rs." + price);
            int req = price * quantity;
            aval.a -= quantity;
            bal.a += req;
            while (req > 0) {
                System.out.print("Please deposit " + req + "Rs.:");
                int dep = scan.nextInt();
                if (dep > req) {
                    System.out.println("returned amount:Rs." + (dep - req));
                    req = 0;
                } else {
                    req -= dep;
                }
            }
            System.out.println("Collect Your item at the bottom and enjoy.");
        }
    }
    public static void main(String ar[]) {
        Scanner scan = new Scanner(System.in);
        int temp = 0;
        integers qcandy = new integers(100);
        integers qchips = new integers(100);
        integers qgum = new integers(100);
        integers qcookies = new integers(100);
        int pcandy = 10, pchips = 20, pgum = 5, pcookies = 40;
        integers bal = new integers(0);
        while (temp != 9) {
            System.out.println("*** Welcome to candy Shop ***\nTo select an item,enter");
            System.out.println("1 for Candy\n2 for Chips\n3 for Gum\n4 for Cookies\n9 for exit");
            temp = scan.nextInt();
            if (temp > 4 || temp < 1) {
                continue;
            }
            System.out.print("Enter the quantity:");
            int quantity = scan.nextInt();
            switch (temp) {
                case 1:
                    update(qcandy, bal, quantity, pcandy);
                    break;
                case 2:
                    update(qchips, bal, quantity, pchips);
                    break;
                case 3:
                    update(qgum, bal, quantity, pgum);
                    break;
                case 4:
                    update(qcookies, bal, quantity, pcookies);
                    break;
            }
        }
        System.out.println("Items inventory:\nCandy:" + qcandy.a + "\nChips:" + qchips.a);
        System.out.println("Gum:" + qgum.a + "\nCookies:" + qcookies.a);
        System.out.println("Current balance:Rs." + bal.a);
    }
}
