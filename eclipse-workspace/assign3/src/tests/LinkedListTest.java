package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.problemdomain.User;
import sait.sll.utility.*;


class LinkedListTest {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	private User user;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}
	
	@Test
	void testReplaceObject() {
		String oldObject = "a";
		String newObject = "b";
		
		this.linkedList.append(oldObject);
		this.linkedList.replace(newObject, 0);
		
		assertFalse(this.linkedList.isEmpty()); //List must have one object to replace with
		assertEquals(1, linkedList.size(), "List length should only be one after replacing the only object");
		assertEquals(newObject, linkedList.retrieve(0), "The first element should replace the old element");
	}
	
	@Test
	void testAppendObject() {
		String newObject = "TestObject";
		
		this.linkedList.append(newObject);
		
		assertEquals(1, linkedList.size(), "List length should be one after appending to an empty list");
		assertEquals (newObject, linkedList.retrieve(0), "The first element should be the appeneded object");
	}
	
	@Test
	void testFindObject() {
		String testObject1 = "a";
		String testObject2 = "b";
		String testObject3 = "c";
		
		this.linkedList.append(testObject1);
		this.linkedList.append(testObject2);
		this.linkedList.append(testObject3);
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}
	
	@Test
	void testDeleteObject() {
		String testObject1 = "a";
		String testObject2 = "b";
		String testObject3 = "c";
		
		this.linkedList.append(testObject1);
		this.linkedList.append(testObject2);
		this.linkedList.append(testObject3);
		
		this.linkedList.delete(2);
		
		assertFalse(this.linkedList.isEmpty());
		assertEquals(2, this.linkedList.size());
		assertEquals(testObject1, this.linkedList.retrieve(0));
		assertEquals(testObject2, this.linkedList.retrieve(1));
	}
	
	@Test
	void testPrependObject() {
		String testObject1 = "a";
		String testObject2 = "b";
		
		this.linkedList.prepend(testObject1);
		this.linkedList.prepend(testObject2);
		
		//object2, object1
		
		assertFalse(this.linkedList.isEmpty());
		assertEquals(2, this.linkedList.size());
		assertEquals(testObject2, this.linkedList.retrieve(0));
		assertEquals(testObject1, this.linkedList.retrieve(1));
	}
	
	void testInsertObject() {
		String testObject1 = "a";
		String testObject2 = "b";
		String testObject3 = "c";
		
		this.linkedList.append(testObject1);
		this.linkedList.append(testObject2);
		this.linkedList.insert(testObject3, 1);
		
		assertFalse(this.linkedList.isEmpty());
		assertEquals(3, this.linkedList.size());
		assertEquals(testObject1, this.linkedList.retrieve(0));
		assertEquals(testObject3, this.linkedList.retrieve(1));
		assertEquals(testObject2, this.linkedList.retrieve(3));
	}

	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is d
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is c
		assertEquals("c", this.linkedList.retrieve(1));
		
		// Test the third node value is b
		assertEquals("b", this.linkedList.retrieve(2));
		
		// Test the fourth node value is a
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}
	
	@Test
	void testUser() {
		this.user = new User(1234, "Peter Parker", "Peterman1234@gmail.com", "SecretIdentity4321");
	}
	
	@Test
	void testReplaceUser() {
		this.user = new User(1, "Miles Morales", "Spiderman@gmail.com", "ACKsnj21");
		this.user = new User(2, "Peni Parker", "SPdrSuit@gmail.com", "SPdrGirl236");
		
		this.linkedList.append(1);
		this.linkedList.replace(2, 0);
		
		assertFalse(this.linkedList.isEmpty()); //List must have one object to replace with
		assertEquals(1, linkedList.size(), "List length should only be one after replacing the only object");
		assertEquals(2, linkedList.retrieve(0), "The first element should replace the old element");
	}
	
	@Test
	void testFindUser() {
		this.user = new User(1, "Miles Morales", "Spiderman@gmail.com", "ACKsnj21");
		this.user = new User(2, "Peni Parker", "SPdrSuit@gmail.com", "SPdrGirl236");
		this.user = new User(3, "Hobie Brown", "Spiderpunk@gmail.com", "P@ssw0rd");
		
		this.linkedList.append(1);
		this.linkedList.append(2);
		this.linkedList.append(3);
		
		boolean contains = this.linkedList.contains(2);
		assertTrue(contains);
		
		int index = this.linkedList.indexOf(2);
		assertEquals(1, index);
		
		int value = (int) this.linkedList.retrieve(1);
		assertEquals(2, value);
	}
	
//	@Test
//	void testInsertUser() {
//		this.user = new User(1, "Miles Morales", "Spiderman@gmail.com", "ACKsnj21");
//		this.user = new User(2, "Peni Parker", "SPdrSuit@gmail.com", "SPdrGirl236");
//		this.user = new User(3, "Hobie Brown", "Spiderpunk@gmail.com", "P@ssw0rd");
//		
//		this.linkedList.append(1);
//		this.linkedList.append(2);
//		this.linkedList.insert(3, 0);
//		
//	}
}
