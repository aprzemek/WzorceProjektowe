package fasada;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Fasada fasada = new Fasada();

		fasada.MetodaA();
		fasada.MetodaB();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class PodSystemPierwszy
	{
		public final void MetodaPierwsza()
		{
			System.out.println(" PodSystemPierwszy Metoda");
		}
	}
	private static class PodSystemDrugi
	{
		public final void MetodaDruga()
		{
			System.out.println(" PodSystemDrugi Metoda");
		}
	}
	private static class PodSystemTrzeci
	{
		public final void MetodaTrzecia()
		{
			System.out.println(" PodSystemTrzeci Metoda");
		}
	}
	private static class PodSystemCzwarty
	{
		public final void MetodaCzwarta()
		{
			System.out.println(" PodSystemCzwarty Metoda");
		}
	}
	private static class Fasada
	{
		private PodSystemPierwszy _pierwszy;
		private PodSystemDrugi _dwa;
		private PodSystemTrzeci _trzy;
		private PodSystemCzwarty _cztery;

		public Fasada()
		{
			_pierwszy = new PodSystemPierwszy();
			_dwa = new PodSystemDrugi();
			_trzy = new PodSystemTrzeci();
			_cztery = new PodSystemCzwarty();
		}

		public final void MetodaA()
		{
			System.out.println("\nMetodaA() ---- ");
			_pierwszy.MetodaPierwsza();
			_dwa.MetodaDruga();
			_cztery.MetodaCzwarta();
		}

		public final void MetodaB()
		{
			System.out.println("\nMetodaB() ---- ");
			_dwa.MetodaDruga();
			_trzy.MetodaTrzecia();
		}
	}
}