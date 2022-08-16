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
    /* TODO: fill in the rest of this class. */

    public static void initiate() {

        // If the .gitlet directory does not exist, it will create the directories needed for the program
        if (!GITLET_DIR.exists()) {

            // Create the .gitlet directory
            GITLET_DIR.mkdir();
            // Create the commits folder within the .gitlet directory
            OBJECT_DIR.mkdir();
            // Create the staging area
            StagingArea.SetTheStage();

            // TODO: How will I make sure the code is not redundant?
            // TODO: Change how the repository organizes the .gitlet files
            /** For example: **/

            // Create the initial commit
            Commit initialCommit = new Commit();
            // Save the initial commit
            initialCommit.SaveCommit(initialCommit);

        } else {
            // Prompts the user that a Repository is already initialized
            System.out.println(RepoExists());
        }
    }

    // Private class that returns a string stating that a repo already exists.
    private static String RepoExists() {
        return "A Gitlet version-control system already exists in the current directory.";
    }


}
