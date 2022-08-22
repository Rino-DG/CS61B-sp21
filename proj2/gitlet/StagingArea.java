package gitlet;

import java.io.Serializable;

public class StagingArea implements Serializable {
    // Use HashMap or TreeMap?

    /**
     * We need to easily be able to remove and add objects/values from this data structure, we also need to easily look
     * up commits by their sha-1 ID.
     *
     * Staging area IS the index file in GIT. It stores information of what will go in the next commit.
     * It will kind of function similarly to STORY from lab 6 in capers. There will be an index file,
     * that will store the sha-1 hash of the blobs that are being added. It should be a MAP for sure,
     * the key will be the sha-1 hash and the value will be the contents of the blob
     * @param fileName
     */

    // Method that adds a file to the Staging Area
    public static void Add(String fileName) {

    }

}
