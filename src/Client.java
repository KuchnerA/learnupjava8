import java.io.*;

public class Client implements Serializable {
    private String name;
    private int age;
    private int salary;
    private int propertyValue;
    private transient File file;

    public Client(String name, int age, int salary, int propertyValue) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.propertyValue = propertyValue;
    }

    public void connectToFile(File file) {
        this.file = file;
    }

    public void save() {
        try (ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file))) {
            ostream.writeObject(this);
        } catch (IOException e) {

        }
    }

    public static Client loadFromFile(File file) {
        Client c2 = null;
        try (ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file))) {
            c2 = (Client) istream.readObject();
            c2.connectToFile(file);
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c2;
    }

    @Override
    public String toString() {
        return ("Client:" +
                "name:" + this.name +
                ", age: " + this.age +
                ", salary:" + this.salary +
                ", propertyValue:" + this.propertyValue +
                ", file:" + this.file);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }
}

