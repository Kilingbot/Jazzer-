import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_39fa7c24dbe5f36358dd67a60f494f5b66c0166a {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAALdwQAAAALc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cFv/ev9zcQB+AAL/////c3EAfgACAAAAA3NxAH4AAgAAAIBzcQB+AAIAAACAc3EAfgACAAAAB3EAfgAFc3IAEWphdmEubGFuZy5Cb29sZWFuzSBygNWc+u4CAAFaAAV2YWx1ZXhwAHEAfgALcQB+AAt1cgACW0Ks8xf4BghU4AIAAHhwAAAAB//YBwAAAAB4");

    public static void main(String[] args) throws Throwable {
        Crash_39fa7c24dbe5f36358dd67a60f494f5b66c0166a.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = TurboJpegFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = TurboJpegFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        TurboJpegFuzzer.fuzzerTestOneInput(input);
    }
}