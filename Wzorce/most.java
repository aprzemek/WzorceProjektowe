package most;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Abstrakcja ab = new AbstrakcjaPochodna();

		ab.setImplementacja(new SpecyficznaImplementacja());
		ab.MetodaImplementacji();

		ab.setImplementacja(new JakasInnaImplementacja());
		ab.MetodaImplementacji();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Implementacja
	{
		public abstract void MetodaImplementacji();
	}
	private static class Abstrakcja
	{
		protected Implementacja implementacja;

		public final void setImplementacja(Implementacja value)
		{
			implementacja = value;
		}

		public void MetodaImplementacji()
		{
			implementacja.MetodaImplementacji();
		}
	}
	private static class AbstrakcjaPochodna extends Abstrakcja
	{
		@Override
		public void MetodaImplementacji()
		{
			implementacja.MetodaImplementacji();
		}
	}
	private static class SpecyficznaImplementacja extends Implementacja
	{
		@Override
		public void MetodaImplementacji()
		{
			System.out.println("SpecyficznaImplementacja MetodaImplementacji");
		}
	}
	private static class JakasInnaImplementacja extends Implementacja
	{
		@Override
		public void MetodaImplementacji()
		{
			System.out.println("JakasInnaImplementacja MetodaImplementacji");
		}
	}
}