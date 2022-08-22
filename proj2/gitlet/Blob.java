package gitlet;

import java.io.File;
import java.io.Serializable;

public class Blob implements Serializable {

    /**
     * Retrieves the file from the CWD, imports the contents of that file to a blob,
     * whilst also calculating a sha-1 hash, then creates a blob object
     * @param fileName
     */
    public static void Create(String fileName) {
        // Get the file url
        File importFile = Utils.join(Repository.CWD, fileName);
        // Get the contents of the file represented as bytes.
        byte[] fileContents = Utils.readContents(importFile);

        // Calculate sha-1 hash for the file
        String blobSha = Utils.sha1((Object) fileContents);

        // Write the blob object to the objects directory
        File newBlobFile = Utils.join(Repository.OBJECT_DIR, blobSha);
        Utils.writeContents(newBlobFile, (Object) fileContents);

    }


}
