import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_229e094efee4f04e9a064fb6a2977e1f94349b56 {
    static final String base64Bytes = String.join("", "/9gG2Aff2//AABMABAbR/9va/9gAAALb2FvYDv//");

    public static void main(String[] args) throws Throwable {
        Crash_229e094efee4f04e9a064fb6a2977e1f94349b56.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = JpegImageParserFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = JpegImageParserFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        JpegImageParserFuzzer.fuzzerTestOneInput(input);
    }
}