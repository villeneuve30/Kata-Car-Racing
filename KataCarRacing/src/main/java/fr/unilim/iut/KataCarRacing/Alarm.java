package fr.unilim.iut.KataCarRacing;

public class Alarm {
	private final double LowThreshold = 17;
	private final double HighThreshold = 21;

	private Sensor sensor;
	private boolean alarmOn;

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
		this.alarmOn = false;
	}
	
	public Alarm() {
		this(new PressureSensor());
	}

	public void check() {
		double value = pressureValue();

		if (IsNotSafe(value)) {
			activateAlarm();
		}
	}

	private void activateAlarm() {
		alarmOn = true;
	}

	private double pressureValue() {
		return sensor.probeValue();
	}

	private boolean IsNotSafe(double value) {
		return value < LowThreshold || HighThreshold < value;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}