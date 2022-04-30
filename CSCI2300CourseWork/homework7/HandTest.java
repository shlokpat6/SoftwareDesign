import org.junit.*;
import static org.junit.Assert.*;

public class HandTest
{
	// Declare deck, player, and dealer objects
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
	
	/* Adding an ace worth 11 to an empty hand would make the total 
	 * value of the hand be less than 21, so ace should be worth 11
	 */
	@Test
	public void test1()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 11", 11 , handValue);
	}
	
	/* Adding an ace worth 11 to the hand would make the total value
	 * of the hand become 21, so ace should be worth 11
	 */
	@Test
	public void test2()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 11", 21 , handValue);
	}
	
	/* Adding an ace worth 11 to the hand would make the total value
	 * of the hand go over 21, so ace should be worth 1
	 */
	@Test
	public void test3()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.TWO, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 1", 13 , handValue);
	}
	
	/* Adding an ace worth 11 to the hand would make the total value
	 * of the hand less than 21, so ace should be worth 11
	 */
	@Test
	public void test4()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.SEVEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 11", 18 , handValue);
	}
	
	/* This test makes sure that the suite has no impact on whether
	 * an ace is counted as 1 or 11. The ace in test should amount to 11.
	 */
	@Test
	public void test5()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.NINE, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.SPADES));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 11", 20 , handValue);
	}
	
	
	/* This test makes sure that the suite has no impact on whether
	 * an ace is counted as 1 or 11. The ace in test should amount to 1.
	 */
	@Test
	public void test6()
	{
		int handValue = 0;
		player.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.TWO, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.SPADES));
		handValue = player.getHand().getValue();
		assertEquals("Ace should count as 1", 13 , handValue);
	}
	
	/* The ace in this situation should be worth an 11, so a blackjack 
	 * should have been achieved
	 */
	@Test
	public void test7()
	{
		boolean blackJackAchieved = false;
		player.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		blackJackAchieved = player.getHand().isBlackJack();
		assertEquals("Ace should count as 11", true , blackJackAchieved);
	}
	
	/* The ace in this situation should be worth an 1, so a bust should 
	 * not have happened
	 */
	@Test
	public void test8()
	{
		boolean bustOccured;
		player.getHand().add(new Card(Card.Face.TEN, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.TWO, Card.Suite.CLUBS));
		player.getHand().add(new Card(Card.Face.ACE, Card.Suite.CLUBS));
		bustOccured = player.getHand().isBust();
		assertEquals("Ace should count as 1", false , bustOccured);
	}

	
	
}
