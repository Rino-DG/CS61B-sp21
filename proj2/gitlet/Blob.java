package gitlet;

import java.io.File;
import java.io.Serializable;

public class Blob implements Serializable {

    /** The content of the file **/
    private byte[] content;
    /** The HashID of the Blob **/
    private String selfHashId;
    /** The file url **/
    private File selfUrl;

    public Blob() {
        this.content = null;
    }

    /**
     * Retrieves the file from the CWD, imports the contents of that file to a blob,
     * whilst also calculating a sha-1 hash, then creates a blob object
     * @param fileName
     */
    public void Create(String fileName) {
        // Get the file url
        File importFile = Utils.join(Repository.CWD, fileName);
        // Get the contents of the file represented as bytes.
        content = Utils.readContents(importFile);

        // Calculate sha-1 hash based on the contents of the file.
        selfHashId = Utils.sha1((Object) content);

        // Write the blob object to the objects directory
        File selfUrl = Utils.join(Repository.OBJECT_DIR, selfHashId);
        Utils.writeObject(selfUrl, this);

    }

    public String getSelfHashId() {
        return selfHashId;
    }

    public File getSelfUrl() {
        return selfUrl;
    }


}
