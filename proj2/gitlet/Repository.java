package gitlet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

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

    /** The file that will act as the staging area... AKA index **/
    public static final File INDEX = join(GITLET_DIR, "index");


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
            System.out.println(GitletMessage.RepoExists());
        }
    }

    // TODO: Failure case for if the file does not exist!

    public static void add(String fileName) throws IOException {
        // Create url for filename given
        File addFile = Utils.join(CWD, fileName);

        /**
         * If the user is indeed in an initialized repo and the file that the user is trying to add
         * exists, proceed to add the file to the staging area.
         */
        if (verifiedCwd()) {
            if (fileExists(addFile)) {
                /**
                 * First, a blob will be created that stores the contents of the file that is being added.
                 * The name of the blob will be the sha-1 hash that is computed via the contents of the file.
                 * Second, the staging area will then connect the file from the working directory to the blob
                 * stored in .gitlet. This connection/mapping will be stored in a tree.
                 *
                 */


                // Create a new blob object
                Blob newBlob = new Blob();
                // Serialize the blob object into the objects directory by passing in the File.
                newBlob.save(addFile);

                // If the index file does not exist, create the index file and begin the instantiation of the HashMap
                StagingArea storedStage = new StagingArea();
                if (INDEX.createNewFile()) {
                    storedStage.initiate();
                    /**
                     * If the index file already exists, read in the object within the file so that it can be modified
                     */
                } else {
                    storedStage = StagingArea.fromFile(INDEX);
                }

                // Add that object into the staging area by giving the url of the CWD file and corresponding blob hash
                storedStage.addToStage(addFile, newBlob.getSelfHashId());
                storedStage.save();
            } else {
                // Returns a gitlet message stating that the file does not exists
                GitletMessage.Dne();
            }

        } else {
            // Returns a gitlet message stating that the user is not in an initialized git repository
            GitletMessage.NotGitDir();
        }
    }



    /**
     * Creates default master branch
     */
    public static void setBranchTo(String branchName) {
        writeContents(HEAD, HEAD_PREFIX + branchName);
    }


    /**
     * Helper method that writes the reference of a commit to the MASTER branch.
     * The HEAD is a special pointer to the latest commit! It moves automatically and is always on the current,
     * active branch, whether that be master or another branch that the user has created.
     * @param commitHash
     */
    public static void setHeadTo(String commitHash) {
        writeContents(MASTER, commitHash);
    }

    /**
     * Boolean method that returns whether or not a gitlet directory is initialized.
     * @return
     */
    public static boolean verifiedCwd() {
        return GITLET_DIR.exists() && REFS_DIR.exists();
    }

    /**
     * Boolean method that returns wether or not a file exists given the File path that
     * it SHOULD exist in.
     * @param importFile
     * @return
     */
    public static boolean fileExists(File importFile) {
        return importFile.exists();
    }



}
