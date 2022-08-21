package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class does at a high level.
 *
 *  It will have a Commit area that contains the commit tree. Lastly it will also have a blob area that
 *  contains each of the saved versions of the files. The repository allows us to modify the files in the
 *  working directory based on the snapshot of our choosing
 *
 *  @author Rino De Guzman
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));

    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /** The object directory, that will contain all the objects for the program **/
    public static final File OBJECT_DIR = join(GITLET_DIR, "objects");

    /** The refs directory, that will contain all the refs for the branches. **/
    public static final File REFS_DIR = join(GITLET_DIR, "refs", "heads");

    /** The template for creating the reference to the head **/
    public static final String HEAD_PREFIX = "ref: refs/heads/";

    /** The HEAD file, which contains the ref path for the head **/
    public static final File HEAD = join(GITLET_DIR, "HEAD");

    /** The default name for the initial branch **/
    public static final String DEFAULT_BRANCH = "master";

    /** The file that will contain the HEAD commit **/
    public static final File MASTER = join(REFS_DIR, "master");


    /**
     * This method creates all the directories needed for gitlet to operate. It also makes the initial commit,
     * initiates the master branch, and sets up the HEAD pointer.
     */
    public static void initiate() {

        // If the .gitlet directory does not exist, it will create the directories needed for the program
        if (!GITLET_DIR.exists()) {

            // Create the .gitlet directory
            GITLET_DIR.mkdir();
            // Create the commits folder within the .gitlet directory
            OBJECT_DIR.mkdir();
            // Create the refs directory
            REFS_DIR.mkdirs();


            // Create the initial commit
            Commit initCommit = new Commit();
            // Saves the commit through serialization
            initCommit.SaveCommit();

            // Initiate the branch
            setBranchTo(DEFAULT_BRANCH);

            // Initiate the HEAD pointer
            setHeadTo(initCommit.getSelfHashId());

        } else {
            // Prompts the user that a Repository is already initialized
            System.out.println(RepoExists());
        }
    }

    // Private class that returns a string stating that a repo already exists.
    private static String RepoExists() {
        return "A Gitlet version-control system already exists in the current directory.";
    }

    /**
     * Creates default master branch2
     */
    public static void setBranchTo(String branchName) {
        writeContents(HEAD, HEAD_PREFIX + branchName);
    }

    /**
     * Helper method that writes the reference of a commit to the MASTER branch
     * @param commitHash
     */
    public static void setHeadTo(String commitHash) {
        writeContents(MASTER, commitHash);
    }

}
