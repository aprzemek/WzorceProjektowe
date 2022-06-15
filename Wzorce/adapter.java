package adapter;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Sensor celsjusz = new Adapter(new FahrenheitSensor());

		System.out.println(String.format("Fahrenheit Sensor pokazuje temperature w Celsjuszach: %1$s °C", celsjusz.GetTemperatura()));
        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Sensor
	{
		public abstract float GetTemperatura();
	}
	private static class FahrenheitSensor
	{
		private float Temperatura = 99.4f;

		public final float GetTemperatura()
		{
			return Temperatura;
		}
	}
	private static class Adapter extends Sensor
	{
		private FahrenheitSensor fs;

		public Adapter(FahrenheitSensor fs)
		{
			this.fs = fs;
		}

		@Override
		public float GetTemperatura()
		{
			return (fs.GetTemperatura() - 32.0f) * 5.0f / 9.0f;
		}
	}
}