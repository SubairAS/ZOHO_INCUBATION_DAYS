package ThemePark;

import java.time.LocalTime;

public class ThemeParkRunner {
	public static void main(String[] args) {
		if(LocalTime.now().isAfter(LocalTime.of(8,00))) {
		Manager.themeParkManagement();
		}
	}
}