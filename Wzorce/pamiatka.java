package pamiatka;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Inicjator i = new Inicjator();
		i.setStan("Włącz");

		Zarzadzajacy z = new Zarzadzajacy();
		z.setPamiatka(i.UtworzPamiatke());

		i.setStan("Wyłącz");


		i.UstawPamiatke(z.getPamiatka());

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class Pamiatka
	{
		private String _stan;

		public Pamiatka(String stan)
		{
			_stan = stan;
		}

		public final String getStan()
		{
			return _stan;
		}
	}
	private static class Zarzadzajacy
	{
		private Pamiatka _pamiatka;

		public final void setPamiatka(Pamiatka value)
		{
			_pamiatka = value;
		}
		public final Pamiatka getPamiatka()
		{
			return _pamiatka;
		}
	}
	private static class Inicjator
	{
		private String _stan;

		public final String getStan()
		{
			return _stan;
		}
		public final void setStan(String value)
		{
			_stan = value;
			System.out.println("Stan = " + _stan);
		}

		public final Pamiatka UtworzPamiatke()
		{
			return (new Pamiatka(_stan));
		}

		public final void UstawPamiatke(Pamiatka pamiatka)
		{
			System.out.println("Przywracanie stanu...");
			setStan(pamiatka.getStan());
		}
	}
}