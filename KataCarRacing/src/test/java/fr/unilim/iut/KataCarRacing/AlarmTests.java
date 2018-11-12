package fr.unilim.iut.KataCarRacing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AlarmTests {

	@Test
	public void AlarmeDeclenche_ValeurPressionTropBasse() {
		Sensor sensor = capteurQuiSonde(0.0);

		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void AlarmeDeclenche_ValeurPressionTropHaute() {
		Sensor sensor = capteurQuiSonde(30.0);

		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void AlarmePasDeclenche_ValeurDansSeuilSecurite() {
		Sensor sensor = capteurQuiSonde(19.0);

		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void AlarmeResteDeclenche() {
		Sensor sensor = capteurQuiSonde(30.0);

		Alarm alarm = new Alarm(sensor);
		alarm.check();

		when(sensor.probeValue()).thenReturn(19.0);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	private Sensor capteurQuiSonde(double value) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value);
		return sensor;
	}

}
