package self.he.pojo;

public class Goddess {
    private String name;
    private String hair;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    @Override
    public String toString() {
        return "Goddess{" +
                "name='" + name + '\'' +
                ", hair='" + hair + '\'' +
                '}';
    }
}
