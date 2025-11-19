package app.src.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import app.src.main.java.*;

class SociopathTest {
    /**
     * Test Case 1: All person(s) likes 2 but 2 likes no one
     * Expected: 2
     * @throws Exception
     */
    @Test
    void likeNoOneAllLikeTwo() throws Exception {
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1, 2});

        Assertions.assertEquals(2, lab.findTheSociopath(2, likeList));
    }

    /**
     * Test Case 2: No one likes 3
     * Expected: -1
     * @throws Exception
     */
    @Test
    void noOneLikesThree() throws Exception {
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1, 2});

        Assertions.assertEquals(-1, lab.findTheSociopath(3, likeList));
    }

    /**
     * Test Case 3: 3 likes no one but all likes 3
     * Expected: 3
     * @throws Exception
     */
    @Test
    void threeLikesNoOneAllLikesThree() throws Exception {
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,2});
        likeList.add(new int []{1,3});
        likeList.add(new int[]{2,3});

        Assertions.assertEquals(3, lab.findTheSociopath(3,likeList));
    }

    /**
     * Test Case 4: Each person likes someone
     * Expected: -1
     * @throws Exception
     */
    @Test
    void everyoneLikesSomeone() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,3});
        likeList.add(new int[]{2,3});
        likeList.add(new int[]{3,1});

        Assertions.assertEquals(-1, lab.findTheSociopath(3, likeList));
    }

    /**
     * Test Case 5: Invalid group size
     * Expected: -1
     * @throws Exception
     */
    @Test
    void invalidGroupSize() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,2});

        Assertions.assertEquals(-1, lab.findTheSociopath(0, likeList));
    }

    /**
     * Test Case 6: Invalid person
     * Expected: -1
     * @throws Exception
     */
    @Test
    void zeroIsNotAPerson() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,0});

        Assertions.assertEquals(-1, lab.findTheSociopath(0, likeList));
    }

    /**
     * Test Case 7: Person likes themselves
     * Expected: -1
     * @throws Exception
     */
    @Test
    void personLikesThemself() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,2});
        likeList.add(new int[]{2,2});

        Assertions.assertEquals(-1, lab.findTheSociopath(2, likeList));
    }

    /**
     * Test Case 8: Test negative group size
     * Expected: -1
     */
    @Test
    void negativeGroupSize() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,2});

        Assertions.assertEquals(-1, lab.findTheSociopath(-1, likeList));
    }

    /**
     * Test Case 9: Large group size
     * Expected: 5
     */
    @Test
    void largeGroupSize() throws Exception{
        Sociopath lab = new Sociopath();
        List<int[]> likeList = new ArrayList<>();

        likeList.add(new int[]{1,5});
        likeList.add(new int[]{2,5});
        likeList.add(new int[]{3,5});
        likeList.add(new int[]{4,5});

        Assertions.assertEquals(5, lab.findTheSociopath(5, likeList));
    }
}


