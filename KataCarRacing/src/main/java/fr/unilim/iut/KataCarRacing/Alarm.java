package fr.unilim.iut.KataCarRacing;

public class Alarm {
	private final double LowPressureThreshold = 17;
	private final double HighPressureThreshold = 21;

	Sensor sensor = new Sensor();

	boolean alarmOn = false;

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public void check() {
		double psiPressureValue = pressureValue();

		if (badPressureThreshold(psiPressureValue)) {
			alarmOn = true;
		}
	}

	private double pressureValue() {
		return sensor.popNextPressurePsiValue();
	}

	private boolean badPressureThreshold(double psiPressureValue) {
		return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}