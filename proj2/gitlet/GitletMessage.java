package gitlet;

public class GitletMessage {

    /**
     * Simply returns a message declaring that a gitlet repository already exists
     * @return
     */
    public static String RepoExists() {
        return "A Gitlet version-control system already exists in the current directory.";
    }

    public static String Dne() {
        return "File does not exist.";
    }

    public static String NotGitDir() {
        return "Not in an initialized Gitlet directory.";
    }

}
