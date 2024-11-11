package day37.XML.demo2;

public class User {
    private String id;
    private String username;
    private String password;
    private String personid;
    private String mobile;
    private boolean admin;

    public User() {
    }

    public User(String id, String username, String password, String personid, String mobile, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.personid = personid;
        this.mobile = mobile;
        this.admin = admin;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return personid
     */
    public String getPersonid() {
        return personid;
    }

    /**
     * 设置
     * @param personid
     */
    public void setPersonid(String personid) {
        this.personid = personid;
    }

    /**
     * 获取
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * 设置
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", personid = " + personid + ", mobile = " + mobile + ", admin = " + admin + "}";
    }
}
