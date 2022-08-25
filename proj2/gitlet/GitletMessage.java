package gitlet;

public class GitletMessage {

    /**
     * Simply returns a message declaring that a gitlet repository already exists
     * @return
     */
    public static String RepoExists() {
        return "A Gitlet version-control system already exists in the current directory.";
    }

    /**
     * Simply returns a message declaring that a file that is requested, does not exist
     * @return
     */
    public static String Dne() {
        return "File does not exist.";
    }


    /**
     * Simply returns a message declaring that the user is not in an initialized Gitlet directory,
     * thus not allowing the command to run.
     * @return
     */
    public static String NotGitDir() {
        return "Not in an initialized Gitlet directory.";
    }

}
