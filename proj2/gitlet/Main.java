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
                Repository.add(fileName);

                break;
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
