package gitlet;

// TODO: any imports you need here

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import static gitlet.Utils.join;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Rino De Guzman
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     *
     *
     */

    //Folder that the commits live in
    static final File COMMIT_FOLDER = join(Repository.GITLET_DIR, "commits");

    /** The message of this Commit. */
    private String message;
    /** The timestamp of this Commit. **/
    private Date timestamp;
    /** The SHA-1 hexadecimal of the PARENT commit **/
    private String parent;
    /** The hash of the commit itself **/
    private String selfHash;
    /** The references of the blobs it is connected to **/
    private String blob;

    public Commit() {
        this.message = "initial commit";
        this.timestamp = new Date(0);
        this.parent = null;
    }

    public Commit(String message, Date timestamp, String parent) {
        this.message = message;
        this.timestamp = timestamp;
        this.parent = parent;
    }

    public void SaveCommit(Commit commit) {
        Commit newCommit = new Commit();
    }

    /** TODO: Accommodate the failure case
     * TODO: */
}
