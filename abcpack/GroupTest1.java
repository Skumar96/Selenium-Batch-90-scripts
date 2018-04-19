package abcpack;

import org.testng.annotations.Test;

public class GroupTest1 {
	@Test(groups="G1")
	public void meth1()
	{
		System.out.println("meth1 in GT1");
	}
	@Test(groups="G2")
	public void meth2()
	{
		System.out.println("meth2 in GT1");
	}
	@Test(groups="G1")
	public void meth3()
	{
		System.out.println("meth3 in GT1");
	}
	@Test(groups="G2")
	public void meth4()
	{
		System.out.println("meth4 in GT1");
	}

}
