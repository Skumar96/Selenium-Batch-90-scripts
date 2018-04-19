package abcpack;

import org.junit.*;

public class JUnitAnnotations {
	@Before
	public void setUp()
	{
		System.out.println("@Before");
	}
	@After
	public void tearDown()
	{
		System.out.println("@After");
	}
	@BeforeClass
	public static void oneTimeSetUp()
	{
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public static void oneTimeTearDown()
	{
		System.out.println("@AfterClass");
	}
	@Test
	public void testMeth1()
	{
		System.out.println("@Test1");
	}
	@Test
	public void testMeth2()
	{
		System.out.println("@Test2");
	}

}
