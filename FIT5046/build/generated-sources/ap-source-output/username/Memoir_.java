package username;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import username.Cinema;
import username.Usertable;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-26T21:44:32")
@StaticMetamodel(Memoir.class)
public class Memoir_ { 

    public static volatile SingularAttribute<Memoir, Date> dateTime;
    public static volatile SingularAttribute<Memoir, Integer> score;
    public static volatile SingularAttribute<Memoir, Date> movieReleaseDate;
    public static volatile SingularAttribute<Memoir, Cinema> cinemaId;
    public static volatile SingularAttribute<Memoir, String> comment;
    public static volatile SingularAttribute<Memoir, Integer> memoirId;
    public static volatile SingularAttribute<Memoir, String> movieName;
    public static volatile SingularAttribute<Memoir, Usertable> userId;

}