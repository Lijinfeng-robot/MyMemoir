package username;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import username.Usertable;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-26T21:44:32")
@StaticMetamodel(Credentials.class)
public class Credentials_ { 

    public static volatile SingularAttribute<Credentials, Date> signUpDate;
    public static volatile SingularAttribute<Credentials, Integer> id;
    public static volatile SingularAttribute<Credentials, Usertable> userId;
    public static volatile SingularAttribute<Credentials, String> passwordHash;
    public static volatile SingularAttribute<Credentials, String> username;

}