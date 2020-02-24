public class towersOfHanoi {
	public void myFunction(int n, String src, String dst, String aux)
	{
		if (n==1)
		{
			System.out.print("Disk 1: "+src+" -> "+dst);
			return;
		}
		else
		{
			myFunction(n-1, src, aux, dst);
			System.out.print("Disk "+n+": "+src+" -> "+dst);
			myFunction(n-1, aux, dst, src);
		}
	}
}