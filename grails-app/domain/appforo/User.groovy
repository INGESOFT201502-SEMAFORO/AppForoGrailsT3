package appforo



class User {
    String name
    String lastname
    Integer age
    String username
    String password



    static constraints = {
        name(blank:false, unique:false, minSize: 3, maxSize: 50)
        lastname(blank:false, unique:false, minSize: 3, maxSize: 50)
        age(nullable: false, min: 13)
        username(blank:false, unique:true)
        password(blank:false, matches: /(\w*([A-Z])+\w*([0-9])+\w*)|(\w*([0-9])+\w*([A-Z])+\w*)/)

    }


}
