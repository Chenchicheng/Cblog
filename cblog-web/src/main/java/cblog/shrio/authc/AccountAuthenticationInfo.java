package cblog.shrio.authc;

import cblog.core.data.AccountProfile;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

/**
 * Created by asus on 17-10-14.
 */
public class AccountAuthenticationInfo extends SimpleAuthenticationInfo {
    private AccountProfile profile;

    public AccountAuthenticationInfo(){
    }

    public AccountAuthenticationInfo(Object principal, Object credentials, String realmName){
        super(principal, credentials, realmName);
    }

    public AccountProfile getProfile() {
        return profile;
    }

    public void setProfile(AccountProfile profile) {
        this.profile = profile;
    }
}
