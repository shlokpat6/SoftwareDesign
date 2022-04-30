import org.junit.*;
import static org.junit.Assert.*;

public class UseCasesTest
{
	Deck deck;
    Player player;
    Dealer dealer;
    
    // Initialize all three objects before each test
    @Before
    public void setUp()
	{
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
	}
	
	/* Since the hand value is more than 17, the dealer should stand.
	 */
	@Test
	public void test1()
	{
		int handValue = 0;
		dealer.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		dealer.getHand().add(new Card(Card.Face.EIGHT, Card.Suite.CLUBS));
		UseCases.onStand(deck, player, dealer);
		handValue = dealer.getHand().getValue();
		assertEquals("Total hand value should remain unchanged", 18, handValue);
	}
	
	/* Since the hand value is already 17, the dealer should stand.
	 */
	@Test
	public void test2()
	{
		int handValue = 0;
		dealer.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		dealer.getHand().add(new Card(Card.Face.SEVEN, Card.Suite.CLUBS));
		UseCases.onStand(deck, player, dealer);
		handValue = dealer.getHand().getValue();
		assertEquals("Total hand value should remain unchanged", 17, handValue);
	}
	
	/* Since the hand value is 16, the dealer should hit.
	 */
	@Test
	public void test3()
	{
		int handValue = 0;
		boolean hitOccured = false;
		dealer.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		dealer.getHand().add(new Card(Card.Face.SIX, Card.Suite.CLUBS));
		UseCases.onStand(deck, player, dealer);
		handValue = dealer.getHand().getValue();
		if(handValue != 16)
		{
			hitOccured = true;
		}
		assertEquals("Total hand value should have changed after hit", true, hitOccured);
	}
	
	/* Since the hand value is less than 16, the dealer should hit.
	 */
	@Test
	public void test4()
	{
		int handValue = 0;
		boolean hitOccured = false;
		dealer.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		dealer.getHand().add(new Card(Card.Face.FIVE, Card.Suite.CLUBS));
		UseCases.onStand(deck, player, dealer);
		handValue = dealer.getHand().getValue();
		if(handValue != 16)
		{
			hitOccured = true;
		}
		assertEquals("Total hand value should have changed after hit", true, hitOccured);
	}
	
	
	
	
}
