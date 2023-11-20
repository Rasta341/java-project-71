package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "gendiff 1.0",mixinStandardHelpOptions = true,
        description = "Compares two configuration " +
        "files and shows a difference.")
public class App implements Callable{
    @Parameters(index = "0", description = "path to first file")
    private Path filepath1;
    private final Path absoluteFilePath1 = Paths.get(String.valueOf(filepath1)).toAbsolutePath().normalize();
    @Parameters(index = "1+", description = "path to second file")
    private Path filepath2;
    private final Path absoluteFilePath2 = Paths.get(String.valueOf(filepath2)).toAbsolutePath().normalize();
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    public App() throws IOException {
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Differ.genDiff(absoluteFilePath1, absoluteFilePath2, format));
        return null;
    }
}
