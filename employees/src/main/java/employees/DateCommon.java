package employees;

import java.time.LocalDate;

public class DateCommon {

	static LocalDate min(LocalDate ld1, LocalDate ld2) {
		return ld1.isBefore(ld2)?ld1:ld2;
	}
	
	static LocalDate max(LocalDate ld1, LocalDate ld2) {
		return ld1.isAfter(ld2)?ld1:ld2;
	}
}
