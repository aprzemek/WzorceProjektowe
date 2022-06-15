package singleton;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{

		Singleton singletonPierwszy = Singleton.zwrocInstancje();
		Singleton singletonDrugi = Singleton.zwrocInstancje();


		if (singletonPierwszy == singletonDrugi)
		{
			System.out.println("Obiekty to ta sama instancja");
		}

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class Singleton
	{

		private static Singleton _instancja;


		private static Object _syncLock = new Object();


		protected Singleton()
		{
		}

		public static Singleton zwrocInstancje()
		{
			synchronized (_syncLock)
			{
				if (_instancja == null)
				{
					_instancja = new Singleton();
				}

				return _instancja;
			}
		}

	}
}