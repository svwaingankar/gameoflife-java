package domainTests;

import domain.Universe;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @shantaram waingankar
 * 30/7/2014
 */
public class UniverseEvolutionTests {

    @Test
    public void testBlockPattern(){

        System.out.println("Block pattern");
        String stringRepresentation =
                "XX\n" +
                "XX\n";
        Universe universeBefore =  new Universe();
        universeBefore.populateFromString(stringRepresentation);

        System.out.println(universeBefore);

        Universe universeAfter =  universeBefore.evolve();

        Assert.assertTrue(universeAfter.containsCellAt(0,0));
        Assert.assertTrue(universeAfter.containsCellAt(0,1));

        Assert.assertTrue(universeAfter.containsCellAt(1,0));
        Assert.assertTrue(universeAfter.containsCellAt(1,1));
        Assert.assertTrue(universeAfter.cellCount() == 4);

        System.out.println(universeAfter);
    }

    @Test
    public void testBoatPattern(){

        System.out.println("Boat pattern");
        String stringRepresentation =
                "XX.\n" +
                "X.X\n"+
                ".X.\n";
        Universe universeBefore =  new Universe();
        universeBefore.populateFromString(stringRepresentation);
        System.out.println(universeBefore);

        Universe universeAfter =  universeBefore.evolve();

        Assert.assertTrue(universeAfter.containsCellAt(0,0));
        Assert.assertTrue(universeAfter.containsCellAt(0,1));
        Assert.assertTrue(universeAfter.containsCellAt(1,0));
        Assert.assertTrue(universeAfter.containsCellAt(1,2));
        Assert.assertTrue(universeAfter.containsCellAt(2,1));
        Assert.assertTrue(universeAfter.cellCount() == 5);

        System.out.println(universeAfter);
    }

    @Test
    public void testBlinkerPattern(){

        System.out.println("Blinker pattern");
        String stringRepresentation =
                ".X.\n" +
                ".X.\n" +
                ".X.\n" ;
        Universe universeBefore =  new Universe();
        universeBefore.populateFromString(stringRepresentation);
        System.out.println(universeBefore);

        Universe universeAfter =  universeBefore.evolve();

        Assert.assertTrue(universeAfter.containsCellAt(0,1));
        Assert.assertTrue(universeAfter.containsCellAt(1,1));
        Assert.assertTrue(universeAfter.containsCellAt(2,1));
        Assert.assertTrue(universeAfter.cellCount() == 3);

        System.out.println(universeAfter);
    }

    @Test
    public void testToadPattern(){

        System.out.println("Toad pattern");
        String stringRepresentation =
                ".XXX\n" +
                "XXX.\n";
        Universe universeBefore =  new Universe();
        universeBefore.populateFromString(stringRepresentation);
        System.out.println(universeBefore);

        Universe universeAfter =  universeBefore.evolve();

        Assert.assertTrue(universeAfter.containsCellAt(2,-1));
        Assert.assertTrue(universeAfter.containsCellAt(0,0));
        Assert.assertTrue(universeAfter.containsCellAt(0,1));


        Assert.assertTrue(universeAfter.containsCellAt(1,2));
        Assert.assertTrue(universeAfter.containsCellAt(3,0));
        Assert.assertTrue(universeAfter.containsCellAt(3,1));

        Assert.assertTrue(universeAfter.cellCount() == 6);

        System.out.println(universeAfter);

    }
}
