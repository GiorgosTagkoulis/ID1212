package server.model;

import common.ClientObject;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T14:08:59")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile SingularAttribute<Player, Integer> score;
    public static volatile SingularAttribute<Player, String> move;
    public static volatile SingularAttribute<Player, Integer> id;
    public static volatile SingularAttribute<Player, ClientObject> playerObj;
    public static volatile SingularAttribute<Player, String> username;

}