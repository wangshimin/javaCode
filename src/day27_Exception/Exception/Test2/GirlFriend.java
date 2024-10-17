 package day27_Exception.Exception.Test2;

public class GirlFriend {
    private String name;
    private int age;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) throws NameFormatException{
        int len = name.length();
        if (len < 3 || len > 10){
            throw new NameFormatException("格式有误，长度应该在3-10之间");
        }
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) throws AgeoutOfBoundsException{
        if (age < 18 || age > 40){
            throw new AgeoutOfBoundsException("年龄应该在18-40之间，"+age+"超出了范围");
        }
        this.age = age;
    }

    public String toString() {
        return "GirlFriend{name = " + name + ", age = " + age + "}";
    }
}
