package com.zhaolearn.basicmongodb;

public class People {
    //MongoDB中id使用的是_id，会自动转换为id，不需要下横杠
    private String id;
    private String name;
    private String age;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public People() { }
    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public People(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}