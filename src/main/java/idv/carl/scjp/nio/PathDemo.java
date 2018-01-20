package idv.carl.scjp.nio;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;

/**
 * @author Carl Lu
 */
public class PathDemo {

    private final static String fileName = "2018_01_diary.md";

    public static void main(String[] args) throws Exception {
        // /Users/Carl/work/Project/fat-nerd-diary/2018_01/2018_01_diary.md

        // Define absolute path
        Path absolutePath1 = Paths.get("/Users/Carl/work/Project/fat-nerd-diary/2018_01", fileName);
        System.out.println(absolutePath1);
        Path absolutePath2 = Paths.get("/Users/Carl/work/Project", "fat-nerd-diary/2018_01", fileName);
        System.out.println(absolutePath2);

        // Define path relative to file store root
        Path relativePath1 = FileSystems.getDefault().getPath("/Users/Carl/work/Project/fat-nerd-diary/2018_01", fileName);
        System.out.println(relativePath1);
        Path relativePath2 = FileSystems.getDefault().getPath("/Users/Carl/work/Project", "fat-nerd-diary/2018_01", fileName);
        System.out.println(relativePath2);

        // Define path relative to current working directory
        Path relativePathToCurrentWorkingDir = Paths.get("2018_01", fileName);
        System.out.println(relativePathToCurrentWorkingDir);

        // Define path from URI scheme
        URI uri = URI.create("file:///Users/Carl/work/Project/fat-nerd-diary/2018_01/".concat(fileName));
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new Exception("Missing scheme");
        }

        // Check for default provider to avoid loading of installed providers
        if (scheme.equals("file")) {
            System.out.println(FileSystems.getDefault().provider().getPath(uri).toAbsolutePath().toString());
        }

        // If you do not know scheme then use this code. This code check file scheme as well if available.
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if (provider.getScheme().equalsIgnoreCase(scheme)) {
                System.out.println(provider.getPath(uri).toAbsolutePath().toString());
                break;
            }
        }

        // Define path using file system default
        FileSystem fileSystem = FileSystems.getDefault();
        Path fsRelativePath = fileSystem.getPath("2018_01/" + fileName);
        System.out.println(fsRelativePath);
        Path fsAbsolutePath = fileSystem.getPath("/Users/Carl/work/Project/fat-nerd-diary/2018_01", fileName);
        System.out.println(fsAbsolutePath);

        // Using System.getProperty() to build path
        Path sysPropPath = FileSystems.getDefault()
                .getPath(System.getProperty("user.home"), "work/Project/fat-nerd-diary/2018_01", fileName);
        System.out.println(sysPropPath);
    }

}
