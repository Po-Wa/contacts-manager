package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {
        String resp;
        System.out.println("Enter a string:");
        do {
            resp = this.scanner.nextLine();
        } while(resp.length() < 1);
        return resp;
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        String resp;
        do {
            resp = this.scanner.nextLine();
        } while(resp.length() < 1);
        return resp;
    }

    public String getAlphaString(String prompt) {
        String resp;
        boolean isValid = true;
        do {
            System.out.println(prompt);
            do {
                resp = this.scanner.nextLine();
            } while(resp.length() < 1);
            for(int i = 0; i < resp.length(); i++) {
                if(!Character.isLetter(resp.charAt(i))) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
            if(!isValid) {
                System.out.println("Invalid Input: Please enter string without special characters or numbers");
            }
        } while(!isValid);
        return resp;
    }

    public String getNumString(String prompt) {
        String resp;
        boolean isValid = true;
        do {
            System.out.println(prompt);
            do {
                resp = this.scanner.nextLine();
            } while(resp.length() < 1);
            for(int i = 0; i < resp.length(); i++) {
                if(!Character.isDigit(resp.charAt(i))) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
            if(!isValid) {
                System.out.println("Invalid Input: Please enter string without special characters or alphabets");
            }
        } while(!isValid);
        return resp;
    }

    public String getAlphaNumString(String prompt) {
        String resp;
        boolean isValid = true;
        do {
            System.out.println(prompt);
            do {
                resp = this.scanner.nextLine();
            } while(resp.length() < 1);
            for(int i = 0; i < resp.length(); i++) {
                if(!Character.isDigit(resp.charAt(i)) && !Character.isLetter(resp.charAt(i))) {
                    isValid = false;
                    break;
                } else {
                    isValid = true;
                }
            }
            if(!isValid) {
                System.out.println("Invalid Input: Please enter string without special characters");
            }
        } while(!isValid);
        return resp;
    }

    public boolean yesNo() {
        String resp;
        do {
            System.out.println("Yes or No?");
            do {
                resp = this.scanner.next();
            } while(resp.length() < 1);
            if(resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("true") || resp.equalsIgnoreCase("t")) {
                return true;
            } else if(resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("false") || resp.equalsIgnoreCase("f")) {
                return false;
            }
        } while(true);
    }

    public boolean yesNo(String prompt) {
        String resp;
        do {
            System.out.println(prompt);
            do {
                resp = this.scanner.next();
            } while(resp.length() < 1);
            if(resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("true") || resp.equalsIgnoreCase("t")) {
                return true;
            } else if(resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("no") || resp.equalsIgnoreCase("false") || resp.equalsIgnoreCase("f")) {
                return false;
            }
        } while(true);
    }

    public int getInt(int min, int max) {
        String retVal;
        System.out.printf("Enter an integer between %d and %d inclusive:\n", min, max);
        retVal = this.scanner.next();
        try {
            int retval = Integer.valueOf(retVal);
            if(retval >= min && retval <= max) {
                return retval;
            } else {
                return getInt(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(min, max);
        }
    }

    public int getInt(int min, int max, String prompt) {
        String retVal;
        System.out.println(prompt);
        retVal = this.scanner.next();
        try {
            int retval = Integer.valueOf(retVal);
            if(retval >= min && retval <= max) {
                return retval;
            } else {
                return getInt(min, max, prompt);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt(min, max, prompt);
        }
    }

    public int getInt() {
        String retVal;
        System.out.println("Enter an Integer");
        retVal = this.scanner.next();
        try {
            return Integer.valueOf(retVal);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt();
        }
    }

    public int getInt(String prompt) {
        String retVal;
        System.out.println(prompt);
        retVal = this.scanner.next();
        try {
            return Integer.valueOf(retVal);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getInt();
        }
    }

    public double getDouble(double min, double max) {
        String retVal;
        System.out.printf("Enter an integer between %f and %f inclusive:\n", min, max);
        retVal = this.scanner.next();
        try {
            double retval = Double.valueOf(retVal);
            if(retval >= min && retval <= max) {
                return retval;
            } else {
                return getDouble(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getDouble(min, max);
        }
    }

    public double getDouble(double min, double max, String prompt) {
        String retVal;
        System.out.printf(prompt);
        retVal = this.scanner.next();
        try {
            double retval = Double.valueOf(retVal);
            if(retval >= min && retval <= max) {
                return retval;
            } else {
                return getDouble(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getDouble(min, max);
        }
    }

    public double getDouble() {
        String retVal;
        System.out.println("Enter an Double");
        retVal = this.scanner.next();
        try {
            return Double.valueOf(retVal);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getDouble();
        }
    }

    public double getDouble(String prompt) {
        String retVal;
        System.out.println(prompt);
        retVal = this.scanner.next();
        try {
            return Double.valueOf(retVal);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getDouble();
        }
    }

    public String getNewLine(String prompt) {
        //System.out.println("gnlp");
        System.out.println(prompt);
        String retVal = this.scanner.nextLine();
        return retVal;
    }

    public String getNewLine() {
        //System.out.println("gnl");
        String retVal = this.scanner.nextLine();
        return retVal;
    }
}
