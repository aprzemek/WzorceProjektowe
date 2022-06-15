package dekorator;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Produkt p = new Produkt();
		DekoratorA da = new DekoratorA();
		DekoratorB db = new DekoratorB();


		db.UstawKomponent(p);
		da.UstawKomponent(db);


		da.Operacja();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Komponent
	{
		public abstract void Operacja();
	}
	private static class Produkt extends Komponent
	{
		@Override
		public void Operacja()
		{
			System.out.println("Produkt.Operacja()");
		}
	}
	private abstract static class Dekorator extends Komponent
	{
		protected Komponent komponent;

		public final void UstawKomponent(Komponent komponent)
		{
			this.komponent = komponent;
		}

		@Override
		public void Operacja()
		{
			if (komponent != null)
			{
				komponent.Operacja();
			}
		}
	}
	private static class DekoratorA extends Dekorator

	{
		@Override
		public void Operacja()
		{
			super.Operacja();

			DodanaFunkcjonalnosc();
			System.out.println("DekoratorA.Operacja()");
		}

		private void DodanaFunkcjonalnosc()
		{
			System.out.println("Wywołano dodatkową funkcjonalność z dekoratora A");
		}
	}
	private static class DekoratorB extends Dekorator
	{
		@Override
		public void Operacja()
		{
			super.Operacja();
			System.out.println("DekoratorB.Operacja()");
		}

	}
}