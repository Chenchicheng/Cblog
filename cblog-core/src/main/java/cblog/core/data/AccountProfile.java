package cblog.core.data;

/**
 * Created by asus on 17-10-14.
 */
public class AccountProfile extends UserProfile {

    private int roleId;
    private int activeEmail;
    public AccountProfile(long id, String username) {
        super(id, username);
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getActiveEmail() {
        return activeEmail;
    }

    public void setActiveEmail(int activeEmail) {
        this.activeEmail = activeEmail;
    }
}
