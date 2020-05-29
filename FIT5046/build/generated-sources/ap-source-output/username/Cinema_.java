package username;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import username.Memoir;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-26T21:44:32")
@StaticMetamodel(Cinema.class)
public class Cinema_ { 

    public static volatile CollectionAttribute<Cinema, Memoir> memoirCollection;
    public static volatile SingularAttribute<Cinema, String> name;
    public static volatile SingularAttribute<Cinema, String> location;
    public static volatile SingularAttribute<Cinema, Integer> id;

}