package metodaszablonowa;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		KlasaAbstrakcyjna aA = new SpecyficznaKlasaA();
		aA.MetodaSzablonowa();

		KlasaAbstrakcyjna aB = new SpecyficznaKlasaB();
		aB.MetodaSzablonowa();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class KlasaAbstrakcyjna
	{
		public abstract void ZrobCos();
		public abstract void JakasInnaMetoda();

		public final void MetodaSzablonowa()
		{
			ZrobCos();
			JakasInnaMetoda();
			System.out.println("");
		}
	}
	private static class SpecyficznaKlasaA extends KlasaAbstrakcyjna
	{
		@Override
		public void ZrobCos()
		{
			System.out.println("SpecyficznaKlasaA.ZrobCos()");
		}
		@Override
		public void JakasInnaMetoda()
		{
			System.out.println("SpecyficznaKlasaA.JakasInnaMetoda()");
		}
	}
	private static class SpecyficznaKlasaB extends KlasaAbstrakcyjna
	{
		@Override
		public void ZrobCos()
		{
			System.out.println("SpecyficznaKlasaB.ZrobCos()");
		}
		@Override
		public void JakasInnaMetoda()
		{
			System.out.println("SpecyficznaKlasaB.JakasInnaMetoda()");
		}
	}
}