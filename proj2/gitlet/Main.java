package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?

        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                Repository.initiate();

            case "add":
                // TODO: handle the `add [filename]` command
                String fileName = args[1];
                // First check if the user is in a valid working directory
                if (Repository.VerifiedCwd()) {
                    /**
                     * First, a blob will be created that stores the contents of the file that is being added.
                     * The name of the blob will be the sha-1 hash that is computed via the contents of the file.
                     * Second, the staging area will then connect the file from the working directory to the blob
                     * stored in .gitlet. This connection/mapping will be stored in a tree.
                     *
                     */
                    Blob.Create(fileName);
                    //StagingArea.Add(fileName);
                } else {
                    GitletMessage.NotGitDir();
                }

                break;
            // TODO: FILL THE REST IN
        }
    }
}
