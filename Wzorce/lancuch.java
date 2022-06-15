package lancuch;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Przelozony marcin = new Menadzer();
		Przelozony luiza = new Kierownik();
		Przelozony marek = new Prezes();

		marcin.UstawPrzelozonego(luiza);
		luiza.UstawPrzelozonego(marek);

		// Wygeneruj i rozpatrz faktury
		Faktura p = new Faktura(1021, 5050.00, "Delegacja");
		marcin.RozpatrzFakture(p);

		p = new Faktura(1022, 11820.00, "Impreza świąteczna");
		marcin.RozpatrzFakture(p);

		p = new Faktura(1023, 35733.00, "System analityczny");
		marcin.RozpatrzFakture(p);

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class Faktura
	{
		private int Numer;
		public final int getNumer()
		{
			return Numer;
		}
		public final void setNumer(int value)
		{
			Numer = value;
		}
		private double Wartosc;
		public final double getWartosc()
		{
			return Wartosc;
		}
		public final void setWartosc(double value)
		{
			Wartosc = value;
		}
		private String Cel;
		public final String getCel()
		{
			return Cel;
		}
		public final void setCel(String value)
		{
			Cel = value;
		}

		public Faktura(int numer, double wartosc, String cel)
		{
			setNumer(numer);
			setWartosc(wartosc);
			setCel(cel);
		}
	}
	private abstract static class Przelozony
	{
		protected Przelozony przelozony;

		public final void UstawPrzelozonego(Przelozony przelozony)
		{
			this.przelozony = przelozony;
		}

		public abstract void RozpatrzFakture(Faktura faktura);
	}
	private static class Menadzer extends Przelozony
	{
		@Override
		public void RozpatrzFakture(Faktura faktura)
		{
			if (faktura.getWartosc() < 10000.0)
			{
				System.out.printf("%1$s zaakceptowano fakture o numerze %2$s" + "\r\n", this.getClass().getSimpleName(), faktura.getNumer());
			}
			else if (przelozony != null)
			{
				przelozony.RozpatrzFakture(faktura);
			}
		}
	}
	private static class Kierownik extends Przelozony
	{
		@Override
		public void RozpatrzFakture(Faktura faktura)
		{
			if (faktura.getWartosc() < 20000.0)
			{
				System.out.printf("%1$s zaakceptowano fakture o numerze %2$s" + "\r\n", this.getClass().getSimpleName(), faktura.getNumer());
			}
			else if (przelozony != null)
			{
				przelozony.RozpatrzFakture(faktura);
			}
		}
	}
	private static class Prezes extends Przelozony
	{
		@Override
		public void RozpatrzFakture(Faktura faktura)
		{
			if (faktura.getWartosc() < 30000.0)
			{
				System.out.printf("%1$s zaakceptowano fakture o numerze %2$s" + "\r\n", this.getClass().getSimpleName(), faktura.getNumer());
			}
			else
			{
				System.out.printf("Faktura o numerze %1$s wymaga konsultacji!" + "\r\n", faktura.getNumer());
			}
		}
	}
}