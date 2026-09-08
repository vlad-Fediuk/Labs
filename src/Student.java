public class Student{
    
    private String name;
    private Integer age;
    private String group;
    
    Student(String name, Integer age, String group){
        this.name = name;
        this.age = age;
        this.group = group;
    }

    String getName(){
        return name;
    }

    Integer getAge(){
        return age;
    }

    String getGroup(){
        return group;
    }
}