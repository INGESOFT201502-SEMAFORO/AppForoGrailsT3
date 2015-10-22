package appforo
import java.util.Date;
class Forum {	
	
	String name
	Date dateCreated
	String category 
	Date fecha = new Date();
	
	//static belongsTo = [Post:Post]
	
	static constraints = {
		name size: 3..20, unique: true, blank: false, nullable: false
		dateCreated blank: false, nullable: false, date: true, validator: { val -> validateDate(val) }
		category size: 3..15, blank: false, nullable: false
	}
	//if (dateCreated < fecha) {dateCreated = null}
	
		   ;
	   
	   	
}