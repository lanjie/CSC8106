package uk.ac.ncl.csc8106.model;

/**
 * Created with IntelliJ IDEA.
 * User: b3019229
 * Date: 28/11/13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class User {

    private String id;
    private String username;
    private String password;

    public void setId(String id)
        {
            this.id = id;
        }

    public void setUserId(String username)
        {
            this.username=username;
        }

    public void setPassword(String password)
        {
            this.password=password;
        }

    public String getId()
        {
            return this.id;
        }

    public String  getUsername()
        {
            return this.username;
        }

    public String getPassword()
        {
            return this.password;
        }

}