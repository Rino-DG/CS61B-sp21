package gitlet;

public class GitletMessage {

    /**
     * Simply returns a message declaring that a gitlet repository already exists
     * @return
     */
    public static String repoExists() {
        return "A Gitlet version-control system already exists in the current directory.";
    }

    /**
     * Simply returns a message declaring that a file that is requested, does not exist
     * @return
     */
    public static String dne() {
        return "File does not exist.";
    }


    /**
     * Simply returns a message declaring that the user is not in an initialized Gitlet directory,
     * thus not allowing the command to run.
     * @return
     */
    public static String notGitDir() {
        return "Not in an initialized Gitlet directory.";
    }

    public static String cmdDne() {
        return "No command with that name exists.";
    }
}
