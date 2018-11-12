package fr.unilim.iut.KataCarRacing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;


public class AlarmTests {

	@Test
	public void AlarmeDeclenche_ValeurPressionTropBasse() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(0.0);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmeDeclenche_ValeurPressionTropHaute() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmePasDeclenche_ValeurDansSeuilSecurite() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(19.0);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void AlarmeResteDeclenche() {
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(19.0);
		
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	
}
