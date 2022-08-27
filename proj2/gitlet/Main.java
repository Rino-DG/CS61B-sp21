package gitlet;

import java.io.IOException;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) throws IOException {
        // TODO: what if args is empty?

        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                Repository.initiate();

            case "add":
                if (args.length > 1) {
                    String fileName = args[1];
                    // First check if the file exists
                    // If not print an error message and exit without changing anything
                    Repository.add(fileName);
                }
                break;

            case "commit":
                if (args.length > 1) {
                    String commitMsg = args[1];
                    Repository.commit(commitMsg);
                }
                break;
            default:
                System.out.println(GitletMessage.cmdDne());
            // TODO: FILL THE REST IN
            /**
             * The commit command will look at the head to retrieve the latest commit!!
             * It uses the HEAD reference/pointer to be able to chain the next commit, the next commit's
             * parent will be the HEAD. After that, the HEAD will change its pointer to the next commit.
             *
             */
        }
    }
}
