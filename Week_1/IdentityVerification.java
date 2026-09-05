public class IdentityVerification {

    public static String reverseCustomerName(String customerName) {
        char[] nameArray = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        
        // Reconstruct string in reverse order
        for (int i = nameArray.length - 1; i >= 0; i--) {
            reversed.append(nameArray[i]);
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}