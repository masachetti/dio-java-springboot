package dio.springboot;

import lombok.Data;

public class Testzinho {
    public static void main(String[] args) {
        DataTest dt = new DataTest(10, "S");
        System.out.println(dt.getNumber());
        System.out.println(dt.getString());
    }
}

@Data
class DataTest{
    private int number;
    private String string;

    public DataTest(int number, String string) {
        this.number = number;
        this.string = string;
    }
}
