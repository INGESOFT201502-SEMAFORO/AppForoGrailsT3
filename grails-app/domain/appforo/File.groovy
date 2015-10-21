package appforo

class File {
    String fileType
    Byte [] content
    double size

    static constraints = {
        fileType(blank: false, nullable: false, matches: /.+\/.+/)
        // TODO: verify that content bytes from file
        size(nullable: false, max: (double)10000000)
    }
}