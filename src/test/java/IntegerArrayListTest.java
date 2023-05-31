import org.example.ElementNotFoundException;
import org.example.IntegerArrayList;
import org.example.InvalidArgumentException;
import org.example.StringListIndexOutOfBoundsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.*;

public class IntegerArrayListTest {
    private IntegerArrayList out=new IntegerArrayList(5);
    @BeforeEach
    public void fillList(){
        out.add(1);
        out.add(2);
        out.add(3);
        out.add(4);
        out.add(5);
    }
    @AfterEach
    public void clearList(){
        out.clear();
    }
    @Test
    public void simpleAdditionPositiveTest(){
        int size=out.size();
        assertEquals(6,out.add(6));
        assertEquals(size+1,out.size());
    }
    @Test
    public void indexedAdditionPositiveTest(){
        int size=out.size();
        int index=1;
        assertEquals(6,out.add(index,6));
        assertEquals( index,out.indexOf(6));
        assertEquals(size+1,out.size());
    }
    @Test
    public void indexedAdditionNegativeTest(){
        assertThrows(StringListIndexOutOfBoundsException.class,()->out.add(5,6));
    }


    @Test
    public void setingPositiveTest(){
        int size=out.size();
        int index=1;
        assertEquals(6,out.set(index,6));
        assertEquals(index,out.indexOf(6));
        assertEquals(size,out.size());
    }
    @Test
    public void settingNegativeTest(){
        assertThrows(StringListIndexOutOfBoundsException.class,()->out.set(5,6));
    }
    @Test
    public void removeByValuePositiveTest(){
        int size=out.size();
        assertEquals(1,out.remove(Integer.valueOf(1)));
        assertEquals(size-1,out.size());
    }
    @Test
    public void removeByValueNegativeTest(){
        assertThrows(ElementNotFoundException.class,()->out.remove(Integer.valueOf(6)));
    }
    @Test
    public void removeByIndexPositiveTest(){
        int size=out.size();
        assertEquals(1,out.remove(0));
        assertEquals(size-1,out.size());
    }
    @Test
    public void removeByIndexNegativeTest(){
        assertThrows(StringListIndexOutOfBoundsException.class,()->out.remove(5));
    }
    public static Stream<Arguments> argumentsForContainsPositiveTest(){
        return Stream.of(Arguments.of(1),
                Arguments.of(3),
                Arguments.of(5));
    }
    @ParameterizedTest
    @MethodSource("argumentsForContainsPositiveTest")
    public void containsPositiveTest(Integer srt){
        assertTrue(out.contains(srt));
    }
    public static Stream<Arguments>argumentsForContainsNegativeTest(){
        return Stream.of(Arguments.of(6),Arguments.of(7),Arguments.of(8));
    }
    @ParameterizedTest
    @MethodSource("argumentsForContainsNegativeTest")
    public void  containsNegativeTest(Integer srt){
        assertFalse(out.contains(srt));
    }
    public static Stream<Arguments>argumentsForIndexOfPositiveTest(){
        return Stream.of(Arguments.of(1,0),
                Arguments.of(2,1),
                Arguments.of(3,2),
                Arguments.of(4,3),
                Arguments.of(5,4));
    }
    @ParameterizedTest
    @MethodSource("argumentsForIndexOfPositiveTest")
    public void indexOfPositiveTest(Integer srt,int index){
        assertEquals(index,out.indexOf(srt));
    }
    public static Stream<Arguments>argumentsForIndexOfNegativetiveTest(){
        return Stream.of(Arguments.of(6,-1),Arguments.of(6,-1));
    }
    @ParameterizedTest
    @MethodSource("argumentsForIndexOfNegativetiveTest")
    public void IndexOfNegativetiveTest(Integer srt,int index){
        assertEquals(index,out.indexOf(srt));
    }
    public static Stream<Arguments>argumentsForLastIndexOfTest(){
        return Stream.of(Arguments.of(1,5),Arguments.of(2,6),Arguments.of(6,-1));
    }
    @ParameterizedTest
    @MethodSource("argumentsForLastIndexOfTest")
    public void LastIndexOfTest(Integer str,int index){
        out.add(1);
        out.add(2);
        assertEquals(index,out.lastIndexOf(str));
    }
    public static Stream<Arguments>argumentsForGetPositiveTest(){
        return Stream.of(Arguments.of(1,0),Arguments.of(2,1),Arguments.of(3,2),
                Arguments.of(4,3), Arguments.of(5,4));
    }
    @ParameterizedTest
    @MethodSource("argumentsForGetPositiveTest")
    public void getPositiveTest(Integer str,int index){
        assertEquals(str,out.get(index));
    }
    @Test
    public void getNegativeTest(){
        assertThrows(StringListIndexOutOfBoundsException.class,()->out.get(5));
    }
    @Test
    public void egualsPositiveTest(){
        IntegerArrayList test=new IntegerArrayList(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        assertTrue(out.eguals(test));
    }
    @Test
    public void egualsNullNegativeTest(){
        assertThrows(InvalidArgumentException.class,()->out.eguals(null));

    }
    public static Stream<Arguments>argumentsForEgualsNegativeTest(){
        return Stream.of(Arguments.of((new IntegerArrayList(1,2,3))),
                Arguments.of(new IntegerArrayList(1,2,3,6,6)),
                Arguments.of(new IntegerArrayList(0,2,3,6,5)),
                Arguments.of(new IntegerArrayList(1,2,3,6,5)));
    }
    @ParameterizedTest
    @MethodSource("argumentsForEgualsNegativeTest")
    public void egualsNegativeTest(IntegerArrayList arg){
        assertFalse(out.eguals(arg));

    }
    @Test
    public void isEmptyPositiveTest(){
       IntegerArrayList test=new IntegerArrayList(5);
        assertTrue(test.isEmpty());
    }


    @Test
    public void isEmptyNegativeTest(){
        assertFalse(out.isEmpty());
    }
    @Test
    public void toArrayTest(){
       Integer[] test={1,2,3,4,5};
        assertArrayEquals(test,out.toArray());
    }
}
