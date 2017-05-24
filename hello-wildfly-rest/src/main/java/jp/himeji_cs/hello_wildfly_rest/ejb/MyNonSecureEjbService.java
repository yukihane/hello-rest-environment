package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

public interface MyNonSecureEjbService {
    String getText();

    @Local
    interface MyNonSecureEjbLocal extends MyNonSecureEjbService {
    }

    @Remote
    interface MyNonSecureEjbRemote extends MyNonSecureEjbService {
    }
}
