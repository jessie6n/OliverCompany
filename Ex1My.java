class Ex1My{
	public static void main(String[] args){
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.print("請輸入成績A:");
		int a=sc.nextInt();
		System.out.print("請輸入成績B:");
		int b=sc.nextInt();
		System.out.print("請輸入學期加分:");
		int c=sc.nextInt();

		double sum=(a+b)/2.0;
		if (sum>=60) sum+=c;
		else if (a>=60 || b>=60) sum+=1;

		System.out.println("總成績為:"+sum);		
	}

}