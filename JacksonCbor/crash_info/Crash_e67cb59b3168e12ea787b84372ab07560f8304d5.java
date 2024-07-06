import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_e67cb59b3168e12ea787b84372ab07560f8304d5 {
    static final String base64Bytes = String.join("", "kg==");

    public static void main(String[] args) throws Throwable {
        Crash_e67cb59b3168e12ea787b84372ab07560f8304d5.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = JacksonCborFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = JacksonCborFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        byte[] input = java.util.Base64.getDecoder().decode(base64Bytes);
        JacksonCborFuzzer.fuzzerTestOneInput(input);
    }
}