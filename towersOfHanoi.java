public class towersOfHanoi {
	public static void main(String[] args){
		if(args.length==1)
		{
			myFunction(Integer.parseInt(args[0]), "First Peg", "Third Peg", "Second Peg");
		}
		else {
			myFunction(3, "First Peg", "Third Peg", "Second Peg");
		}
	}

	public static void myFunction(int n, String src, String dst, String aux)
	{
		if (n==1)
		{
			System.out.println("Disk 1: "+src+" -> "+dst);
			return;
		}
		else
		{
			myFunction(n-1, src, aux, dst);
			System.out.println("Disk "+n+": "+src+" -> "+dst);
			myFunction(n-1, aux, dst, src);
		}
	}
}