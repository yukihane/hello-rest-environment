package jp.himeji_cs.hello_wildfly_rest.ejb;

import javax.ejb.Local;

@Local
public interface MyEjbLocal {
    
    public String getText();

}
