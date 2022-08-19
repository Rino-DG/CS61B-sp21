package gitlet;

import java.io.File;

public class Branch {

    // String that will contain the sha-1 hash of a commit
    private Commit pointer;
    // String that is the name of the Branch itself
    private String branchName;

    public static void initiateBranch(Commit commit) {
        // Get the file of the commit
        String shaString = Utils.sha1(commit);
        // Get the sha-1 from the file

        // Write it into the branch file

        // name the branch master
    }

}
