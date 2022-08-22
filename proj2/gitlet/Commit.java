package gitlet;

// TODO: any imports you need here

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static gitlet.Utils.join;
import static gitlet.Utils.sha1;

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


    /** The message of this Commit. */
    private String message;
    /** The timestamp of this Commit. **/
    private Date timestamp;
    /** The SHA-1 hexadecimal of the PARENT commit **/
    private ArrayList<String> parent;
    /** The hash of the commit itself **/
    private String selfHashId;
    /** The references of the blobs it is connected to **/
    private String blob;

    // Constructor that represents the initial commit
    public Commit() {

        this.message = "initial commit";
        this.timestamp = new Date(0);
        this.parent = new ArrayList<>();
        this.selfHashId = createHashId();
    }

    // Overloaded constructor that will represent all commits past the initial commit
    public Commit(String message, Date timestamp, ArrayList<String> parent) {

        this.message = message;
        this.timestamp = timestamp;
        this.parent = parent;
        this.selfHashId = createHashId();

    }

    public String createHashId() {
        return sha1(message, this.dateToString(), parent.toString());
    }

    /**
     * Helper method that returns a string representation of the Date object. Will be using the code from
     * url: "https://www.javatpoint.com/java-date-to-string" to help format the date.
     * Should be formatted like: "Date: Thu Nov 9 17:01:33 2017 -0800"
     * @return
     */
    public String dateToString() {
        // Initialize SimpleDateFormat object
        SimpleDateFormat formatDate = new SimpleDateFormat("E MMM dd HH:mm:ss Z");
        // Return the formatted date as a string
        return formatDate.format(timestamp);
    }


    /**
     * Saves a commit by writing the commit to a File object then creating a sha-1
     * by passing in the file. Lastly, it will rename the file to the sha-1 hash.
     */
    public void SaveCommit() {

        //Commit newCommit = new Commit(this.message, this.timestamp, this.parent);

        String commitHash = this.getSelfHashId();

        // Write the commit object to a file with a file name as the commit's Sha-1 Hash.
        File newCommitFile = Utils.join(Repository.OBJECT_DIR, commitHash);
        Utils.writeObject(newCommitFile, this);

    }

    public String getSelfHashId() {
        return selfHashId;
    }


}
