import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_f992fcd3e402c763552fe39684524660683d6003 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdXIAAltCrPMX+AYIVOACAAB4cAAAACqs7QAFc3IAB2phei5aZXIAAAAAAAAAKgIAAUIACXNhbml0aXplcnhwAgp4");

    public static void main(String[] args) throws Throwable {
        Crash_f992fcd3e402c763552fe39684524660683d6003.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = CommonsLangFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = CommonsLangFuzzer.class.getMethod("fuzzerInitialize", String[].class);
                fuzzerInitialize.invoke(null, (Object) args);
            } catch (NoSuchMethodException ignored1) {
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }
        com.code_intelligence.jazzer.api.CannedFuzzedDataProvider input = new com.code_intelligence.jazzer.api.CannedFuzzedDataProvider(base64Bytes);
        CommonsLangFuzzer.fuzzerTestOneInput(input);
    }
}