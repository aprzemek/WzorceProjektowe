package stan;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Kontekst k = new Kontekst(new Zielone());


		k.Pokaz();
		k.Pokaz();
		k.Pokaz();
		k.Pokaz();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Swiatlo
	{
		public abstract void Zmien(Kontekst kontekst);
	}
	private static class Kontekst
	{
		private Swiatlo _stan;

		public Kontekst(Swiatlo swiatlo)
		{
			this.setSwiatlo(swiatlo);
		}

		public final Swiatlo getSwiatlo()
		{
			return _stan;
		}
		public final void setSwiatlo(Swiatlo value)
		{
			_stan = value;
			System.out.println("Swiatlo: " + _stan.getClass().getSimpleName());
		}

		public final void Pokaz()
		{
			_stan.Zmien(this);
		}
	}
	private static class Zielone extends Swiatlo
	{
		@Override
		public void Zmien(Kontekst kontekst)
		{
			kontekst.setSwiatlo(new Zolte());
		}
	}
	private static class Zolte extends Swiatlo
	{
		@Override
		public void Zmien(Kontekst kontekst)
		{
			kontekst.setSwiatlo(new Czerwone());
		}
	}
	private static class Czerwone extends Swiatlo
	{
		@Override
		public void Zmien(Kontekst kontekst)
		{
			kontekst.setSwiatlo(new Zielone());
		}
	}
}