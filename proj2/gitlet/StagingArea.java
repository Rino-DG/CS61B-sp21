package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import static gitlet.Utils.readObject;

public class StagingArea implements Serializable {
    // Use HashMap or TreeMap?

    // Initiate HashMap for addition and removal
    private HashMap<File, String> stagedAdd;
    private HashMap<File, String> stagedRem;

    public StagingArea() {
        this.stagedAdd = null;
        this.stagedRem = null;
    }


    /**
     * We need to easily be able to remove and add objects/values from this data structure, we also need to easily look
     * up commits by their sha-1 ID.
     *
     * Staging area IS the index file in GIT. It stores information of what will go in the next commit.
     * It will kind of function similarly to STORY from lab 6 in capers. There will be an index file,
     * that will store the sha-1 hash of the blobs that are being added. It should be a MAP for sure,
     * the key will be the name of the file in the CWD and the value will be the sha-1 hash of the blob
     * @param fileName
     */

    /**
     * Method that adds a file to the Staging Area this will interact with the tree object to connect the file in
     * the current working directory to the corresponding blob in the object directory. The FILENAME of the file
     * is stored in the TREE
      */

    /**
     * Create the index file
     * @param cwdFile blobSha
     */

    public void addToStage(File cwdFile, String blobSha) {
        stagedAdd.put(cwdFile, blobSha);
    }

    public void save() {
        Utils.writeObject(Repository.INDEX, this);
    }

    public void initiate() {
        stagedAdd = new HashMap<>();
        stagedRem = new HashMap<>();
    }

    // Returns the stored staging area object from the index file
    public static StagingArea fromFile(File stageFile) {
        StagingArea storedStage;
        storedStage = readObject(stageFile, StagingArea.class);
        return storedStage;
    }



}
