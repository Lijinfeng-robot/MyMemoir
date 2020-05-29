package username;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import username.Credentials;
import username.Memoir;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-26T21:44:32")
@StaticMetamodel(Usertable.class)
public class Usertable_ { 

    public static volatile SingularAttribute<Usertable, String> address;
    public static volatile SingularAttribute<Usertable, String> gender;
    public static volatile CollectionAttribute<Usertable, Credentials> credentialsCollection;
    public static volatile SingularAttribute<Usertable, String> surname;
    public static volatile SingularAttribute<Usertable, Date> dob;
    public static volatile CollectionAttribute<Usertable, Memoir> memoirCollection;
    public static volatile SingularAttribute<Usertable, Integer> postcode;
    public static volatile SingularAttribute<Usertable, Integer> id;
    public static volatile SingularAttribute<Usertable, String> state;
    public static volatile SingularAttribute<Usertable, String> username;

}