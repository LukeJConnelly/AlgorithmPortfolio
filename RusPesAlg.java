public class RusPesAlg {
	public static void main(String args[])
	{
		long startTime=0; 
		int i=0, j=0, ans=0;
		for (i=1;i<100;i++)
		{
			for (j=i;j<100;j++)
			{
				startTime = System.currentTimeMillis();
				ans=myMethod(i,j);
				startTime= System.currentTimeMillis() - startTime;
				System.out.println(i+" X "+j+" = "+ans+" took "+ startTime +" to run.");
			}
		}
		
	}
	public static int myMethod(int a, int b)
	{
		//a=17;b=15		optional hardcode
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