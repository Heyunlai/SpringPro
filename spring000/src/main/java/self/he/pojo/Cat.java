package self.he.pojo;

public class Cat {
    private String name;
    private String color;
    private Girl girl;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
