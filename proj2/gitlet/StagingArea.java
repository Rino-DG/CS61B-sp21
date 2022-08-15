package gitlet;

import java.io.File;

import static gitlet.Utils.join;

public class StagingArea {

    // Folder that the staged files will live in
    static final File STAGING_FOLDER = join(Repository.GITLET_DIR, "stagedFiles");
    // Folder that will contain the files staged for addition
    static final File STAGING_ADD = join(STAGING_FOLDER, "stagingAdd");
    // Folder that will contain the files staged for removal
    static final File STAGING_REM = join(STAGING_FOLDER, "stagingRem");

    // Method that will create all the directories needed to setup the repository
    public static void SetTheStage() {
        // Create the Staging Area Folder
        STAGING_FOLDER.mkdir();
        // Create the Stage for Addition Folder
        STAGING_ADD.mkdir();
        // Create the Stage for Removal Folder
        STAGING_REM.mkdir();

    }

}
