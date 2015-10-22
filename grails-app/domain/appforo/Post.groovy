package appforo



/**
 * Created by SAMUELLEONARDO on 21/10/2015.
 */
class Post {

    String topic
    Date dateCreated
    Date lastupdate
    Date currentDay = new Date()
    boolean itsAllowed

    static constraints = {
        topic(blank:false, unique:false, minSize: 3, maxSize: 50)
        dateCreated(blank:false, min: currentDay)
        lastupdate(blank:false, min: currentDay)

    }


}
