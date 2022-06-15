package strategia;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Kontekst context;

		// Dwa konteksty z różnymi strategiami
		context = new Kontekst(new SpecyficznaStrategiaA());
		context.ZwrocProblem();

		context = new Kontekst(new SpecyficznaStrategiaB());
		context.ZwrocProblem();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Strategia
	{
		public abstract void RozwiazProblem();
	}
	private static class SpecyficznaStrategiaA extends Strategia
	{
		@Override
		public void RozwiazProblem()
		{
			System.out.println("Wywołano SpecyficznaStrategiaA.RozwiazProblem()");
		}
	}
	private static class SpecyficznaStrategiaB extends Strategia
	{
		@Override
		public void RozwiazProblem()
		{
			System.out.println("Wywołano SpecyficznaStrategiaB.RozwiazProblem()");
		}
	}
	private static class Kontekst
	{
		private Strategia _strategia;

		public Kontekst(Strategia strategia)
		{
			this._strategia = strategia;
		}

		public final void ZwrocProblem()
		{
			_strategia.RozwiazProblem();
		}
	}
}