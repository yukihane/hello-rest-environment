package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

public interface MyEjbService {

    String getText();

    @Local
    interface MyEjbLocal extends MyEjbService {
    }

    @Remote
    interface MyEjbRemote extends MyEjbService {
    }
}
