package day18_API;

import java.util.StringJoiner;

/**
 * Cloneable
 * 如果一个接口里面没有抽象方法，
 * 表示当前的接口是一个标记性接口，
 * 现在Cloneable表示一旦实现了该接口，那么当前类的对象就可以被克隆。
 * 如果没有实现，当前类的对象就不能被克隆。
 */

public class User implements Cloneable{
    private int id;             // 游戏角色
    private String username;    // 用户名
    private String password;    // 密码
    private String path;        // 游戏图片
    private int[] data;         // 游戏进度


    public User() {
    }

    public User(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "角色编号为：" + id + "，用户名："+username+"， 密码："+password+"，游戏图片："+path+"，进度："+ arrayToString();
    }

    public String arrayToString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i = 0; i < data.length; i++) {
            sj.add(data[i] + "");
        }
        return sj.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用父类中的clone()方法
        // 相当于让Java帮我们克隆一个对象，并把克隆之后的对象返回出去。

        // 先把被克隆对象中的数组获取出来
        int[] data = this.data;
        // 创建新的数组
        int[] newData = new int[data.length];
        // 拷贝数组中的数据
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        // 调用父类中的方法克隆对象
        User u = (User) super.clone();
        // 因为父类中的克隆方法是浅克隆，所以这里需要替换克隆出来对象中的数组地址值
        u.data = newData;
        return u;
    }
}
