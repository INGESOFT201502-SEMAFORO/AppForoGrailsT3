package appforo

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class File {
    String fileType
    Byte [] content
    double fileSize

    private java.io.File file
    private Path path

    static transients = ['file', 'path']

    File(String path) {
        this.path = Paths.get(path)
        content = Files.readAllBytes(path)
        file = path.toFile()
        fileSize = file.length().toDouble()
        fileType = Files.probeContentType(path)
    }

    static constraints = {
        fileType(blank: false, nullable: false, matches: /.+\/.+/)
        content(nullable: false, size: fileSize, validator: {val, obj ->
            java.io.File tempFile = new File(path.toString())
            if(tempFile.equals(file)) return true
        })
        fileSize(nullable: false, max: (double)10000000)
    }
}
