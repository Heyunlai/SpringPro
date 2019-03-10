package self.he.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
    private  String name;
    private  Integer age;
    private String[] friends;
    private List<Integer> nums;
    private Set<Girl> grils;
    private Map<String,Goddess> goddessMap;

    public Map<String, Goddess> getGoddessMap() {
        return goddessMap;
    }

    public void setGoddessMap(Map<String, Goddess> goddessMap) {
        this.goddessMap = goddessMap;
    }

    public Set<Girl> getGrils() {
        return grils;
    }

    public void setGrils(Set<Girl> grils) {
        this.grils = grils;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }
}
