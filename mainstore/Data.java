/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstore;

/**
 *
 * @author easterPC
 */
public class Data {
    
public static String[] productName = {"Rice", "Sugar", "Coffee", "Milk"};
    public static double[] productPrice = {50.0, 25.0, 25.0, 15.0};
    public static int[] productQuantity = {20, 20, 20, 20};
    public static int productCount = 4;
    
    public static String[] cartNames = new String[100];
    public static int[] cartQty = new int[100];
    public static double[] cartTotal = new double[100];
    public static int cartCount = 0;
    
   
    public static String[] logProducts = new String[500];
    public static int[] logQty = new int[500];
    public static double[] logTotal = new double[500];
    public static int logCount = 0;
    
    public static String[] getProductList(){
        String[] list = new String[productCount];
        for (int i = 0; i < productCount; i++){
            list[i] = productName[i] + "-" + productPrice[i] + "(" + productQuantity[i] + "pcs)";
        }
        return list;
    }
    
    public static boolean addToCart(int index, int quantity) {
        if (index < 0 || index >= productCount) return false;
        if (quantity > productQuantity[index]) return false;

        double total = quantity * productPrice[index];
        cartNames[cartCount] = productName[index];
        cartQty[cartCount] = quantity;
        cartTotal[cartCount] = total;

        productQuantity[index] -= quantity;
        cartCount++;
        return true;
    }
    
    public static double getGrandTotal() {
        double total = 0;
        for (int i = 0; i < cartCount; i++) {
            total += cartTotal[i];
        }
        return total;
    }
    
    public static String getReceipt() {
        String receipt = "";
        for (int i = 0; i < cartCount; i++) {
            receipt += cartNames[i] + " x" + cartQty[i] + " =" + cartTotal[i] + "\n";
        }
        receipt += "TOTAL: " + getGrandTotal();
        return receipt;
    }

    
    public static void processCheckout() {
        
        for (int i = 0; i < cartCount; i++) {
            logProducts[logCount] = cartNames[i];
            logQty[logCount] = cartQty[i];
            logTotal[logCount] = cartTotal[i];
            logCount++; 
        }
        clearCart(); 
    }

    public static void clearCart() {
        cartCount = 0;
    }

}
