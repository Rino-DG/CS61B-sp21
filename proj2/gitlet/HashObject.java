package gitlet;

import java.io.File;

public class HashObject {

    // Hashes the commit object
    public static String returnHash(File inputFile) {
        byte[] actualSha = Utils.readContents(inputFile);
        String shaString = Utils.sha1((Object) actualSha);
        return shaString;
    }

}
