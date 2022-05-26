package ru.job4j.io.packing;

public class PackParams {
    private final String sourceDirectory;
    private final String targetZIP;
    private final String excludeExtension;

    public PackParams(String sourceDirectory, String targetZIP, String excludeExtension) {
        this.sourceDirectory = sourceDirectory;
        this.targetZIP = targetZIP;
        this.excludeExtension = excludeExtension;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public String getTargetZIP() {
        return targetZIP;
    }

    public String getExcludeExtension() {
        return excludeExtension;
    }
}
