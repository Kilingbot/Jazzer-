
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;

import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * @author Rohan Padhye
 */
@RunWith(JQF.class)
public class GifReaderTest {
    @BeforeClass
    public static void disableCaching() {
        // Disable disk-caching as it slows down fuzzing
        // and makes image reads non-idempotent
        ImageIO.setUseCache(false);
    }

    private ImageReader reader;

    @Before
    public void setUp() {
        Assert.assertNotNull(this.reader = ImageIO.getImageReadersByFormatName("gif").next());
    }

    @After
    public void tearDown() {
        this.reader.dispose();
    }

    @Fuzz
    public void read(ImageInputStream input) throws IOException, IndexOutOfBoundsException {
        // Decode image from input stream
        reader.setInput(input);
        // Bound dimensions
        int width = reader.getWidth(0);
        int height = reader.getHeight(0);
        Assume.assumeTrue(width > 0 && width < 1024);
        Assume.assumeTrue(height > 0 && height < 1024);
        // Parse GIF
        reader.read(0);
    }

    @Fuzz
    public void getWidth(ImageInputStream input) throws IOException, IndexOutOfBoundsException {
        // Decode image from input stream
        reader.setInput(input);
        int width = reader.getWidth(0);
        System.out.println(width);
    }

    @Fuzz
    public void getHeight(ImageInputStream input) throws IOException, IndexOutOfBoundsException   {
        // Decode image from input stream
        reader.setInput(input);
        int height = reader.getHeight(0);
        System.out.println(height);
    }

}
