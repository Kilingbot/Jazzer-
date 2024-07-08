//package org.example;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.ConstructorException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class SnakeYamlFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        Yaml yaml = new Yaml();
        try {
            yaml.load(data.consumeRemainingAsString());
        } catch (ConstructorException ignored) {
        }
    }
}