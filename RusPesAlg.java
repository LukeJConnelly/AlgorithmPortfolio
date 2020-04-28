//ARGUMENT GUIDE
//should take two integers only in the args array
//eg. args = {"100", "100"}

public class RusPesAlg {
	public static void main(String args[])
	{
		int i=25, j=63, ans=0;//default numbers, just an example
		if(args.length==2)
		{
			i=Integer.parseInt(args[0]);
			j=Integer.parseInt(args[1]);
		}
		long startTime = System.nanoTime();
		ans=myMethod(i,j);
		startTime= System.nanoTime() - startTime;
		System.out.println(i+" X "+j+" = "+ans+" took "+ startTime +" to run.");
	}
	public static int myMethod(int a, int b)
	{
		int res=0;
		while (b>0)
		{
			if(b%2==1)
			{
				res+=a;
			}
			a*=2;
			b*=0.5;
		}
		return res;
	}
}