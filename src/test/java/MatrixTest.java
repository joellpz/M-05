import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatrixTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,20", "9384,12384"})
    void getWidth_OK(int width,int height) {
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(width, m.getWidth());
    }
    @ParameterizedTest
    @CsvSource({"5,-5", "-10,20", "9384,-12384"})
    void getWidth_NEGATIVE(int width,int height) {
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            new Matrix(width, height);
        });
    }

    @ParameterizedTest
    @CsvSource({"5,5", "10,20", "9384,12384"})
    void getHeight(int width,int height) {
        Matrix m = new Matrix(width,height);
        Assertions.assertEquals(height,m.getHeight());
    }

    @ParameterizedTest
    @CsvSource({"5,-5", "-10,20", "9384,-12384"})
    void getHeight_NEGATIVE(int width,int height) {
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            new Matrix(width, height);
        });
    }

    //TODO
    @org.junit.jupiter.api.Test
    void fill_3_3_3() {
        Matrix m = new Matrix(3,3);
        m.Fill(3);
        Assertions.assertEquals(" [3] [3] [3]\r\n" +
                " [3] [3] [3]\r\n" +
                " [3] [3] [3]\r\n",m.ToString());

    }

    @org.junit.jupiter.api.Test
    void fill_1_1_3() {
        Matrix m = new Matrix(1,1);
        m.Fill(3);
        Assertions.assertEquals(" [3]\r\n",m.ToString());
    }

    @org.junit.jupiter.api.Test
    void fill_2_4_1() {
        Matrix m = new Matrix(2,4);
        m.Fill(1);
        Assertions.assertEquals(" [1] [1] [1] [1]\r\n" +
                " [1] [1] [1] [1]\r\n",m.ToString());
    }

    @org.junit.jupiter.api.Test
    void fill_4_2_1() {
        Matrix m = new Matrix(4,2);
        m.Fill(1);
        Assertions.assertEquals(" [1] [1]\r\n" +
                " [1] [1]\r\n" +
                " [1] [1]\r\n" +
                " [1] [1]\r\n",m.ToString());
    }

    @ParameterizedTest
    @CsvSource({"5,5,11,11", "10,20,0,0", "9384,12384,1,1"})
    void count_OnlyOneValue(int width,int height, int min, int max) {
        Matrix m = new Matrix(width,height);
        m.Fill(min,max);
        Assertions.assertEquals(width*height,m.Count(min));
        Assertions.assertEquals(0,m.Count(min-1));
    }

    @ParameterizedTest
    @CsvSource({"5,5,-11,14", "10,20,-50,0", "9384,12384,1,100"})
    void count(int width,int height, int min, int max) {
        Matrix m = new Matrix(width,height);
        m.Fill(min,max);
        Assertions.assertEquals(0,m.Count(max+1));
        Assertions.assertEquals(0,m.Count(min-1));
    }

    @ParameterizedTest
    @CsvSource({"5,5,11", "10,20,0", "9384,12384,1"})
    void found(int width,int height, int min) {
        Matrix m = new Matrix(width,height);
        m.Fill(min);
        Assertions.assertEquals(true,m.Found(min));
    }

    @ParameterizedTest
    @CsvSource({"3,3,3", "10,20,0", "9384,12384,1"})

    void ToString() {
//        Matrix m = new Matrix(width,height);
//        m.Fill(fillValue);
        //Assertions.assertEquals();
    }
}