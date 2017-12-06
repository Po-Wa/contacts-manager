import java.util.Arrays;

public class Contact {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private int stringMax = 20;

//    +============================================================================+
//    | firstname: 1111111111 | Lastname: 1111111111 | Phone Number: (512)788-1789 |
//    +============================================================================+

    public Contact(String firstname, String lastname, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return firstname+" "+lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void prettyPrint() {
        String str = "";
        str += "+========================================================";
        for(int i = 0; i < stringMax*2; i++) {
            str += "=";
        }
        str += "+\n";
        if (firstname.length() > stringMax) {
            str += "| firstname: "+firstname.substring(0,stringMax);
        } else {
            str += "| firstname: "+firstname;
            for(int i = 0; i < stringMax-firstname.length(); i++) {
                str += " ";
            }
        }
        if (lastname.length() > stringMax) {
            str += " | lastname: "+lastname.substring(0,stringMax);
        } else {
            str += " | lastname: "+lastname;
            for(int i = 0; i < stringMax-lastname.length(); i++) {
                str += " ";
            }
        }
        str += " | Phone Number: (";
        str += phoneNumber.substring(0,3)+")";
        str += phoneNumber.substring(3,6)+"-";
        str += phoneNumber.substring(6,10)+" |\n";
        str += "+========================================================";
        for(int i = 0; i < stringMax*2; i++) {
            str += "=";
        }
        str += "+\n";
        System.out.println(str);

    }

    public static String toString(Contact ct) {
        return ct.getFirstname()+"|"+ct.getLastname()+"|"+ct.getPhoneNumber();
    }

    public static Contact toContact(String ct) {
        return new Contact(ct.split("\\|")[0], ct.split("\\|")[1], ct.split("\\|")[2]);
    }
}
