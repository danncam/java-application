package AdressBook;

/**
 *
 * @author dan
 */
public class Friend {

//    public String name, nick, address, email, phone;
    public String[] data = new String[4];
    private int id = 0; // se id = 0, o contato não existe

//    public Friend(String[] arr) {
//        name = arr[1];
//        nick = name.substring(0, name.indexOf(' '));
//        address = arr[2];
//        email = arr[3];
//        phone = arr[4];
//        id = Integer.parseInt(arr[0]);
//    }

    public Friend(String name, String address, String email, String phone) {
        this.data[0] = name;
        this.data[1] = address;
        this.data[2] = email;
        this.data[3] = phone;
    }
//    public Friend(String name, String address, String email, String phone) {
//        this.name = name;
//        this.address = address;
//        this.email = email;
//        this.phone = phone;
//    }

    public String toLine() {
        if (this.exist()) {
            return this.id + Book.split + this.data[0] + Book.split + this.data[1] + Book.split + this.data[2] + Book.split + this.data[3] + "\n";
        } else {
            return null;
        }
    }

    public boolean exist() {
        return this.id != 0;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int i) {
        this.id = i;
    }
}
